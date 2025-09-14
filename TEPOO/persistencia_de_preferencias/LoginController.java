package TEPOO.persistencia_de_preferencias;

public class LoginController {
  private AuthService authService;
  private PreferenceService preferenceService;
  private LoginView view;

  public LoginController(AuthService authService, PreferenceService preferenceService, LoginView view) {
    this.authService = authService;
    this.preferenceService = preferenceService;
    this.view = view;

    view.setController(this);

    // Carrega preferências ao iniciar
    Preferences prefs = preferenceService.loadPreferences();
    if (prefs.isRememberMe()) {
      view.setRememberedUser(prefs.getUsername());
    }
  }

  public void handleLogin(String username, String password, boolean rememberMe) {
    if (username.isEmpty() || password.isEmpty()) {
      view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    User user = new User(username, password);
    if (authService.authenticate(user)) {
      view.showMessage("Login realizado com sucesso!", "Sucesso");
      preferenceService.savePreferences(username, rememberMe);
    } else {
      view.showMessage("Usuário ou senha incorretos.", "Erro");
    }
  }
}
