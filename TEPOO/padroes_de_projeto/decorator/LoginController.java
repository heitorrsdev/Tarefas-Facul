package TEPOO.padroes_de_projeto.decorator;

public class LoginController {
  private AuthService authService;
  private LoginView view;

  public LoginController(AuthService authService, LoginView view) {
    this.authService = authService;
    this.view = view;

    // Vincula a ação do botão da view ao método do controller
    view.setController(this);
  }

  public void handleLogin(String username, String password) {
    User user = new User(username, password);

    if (username.isEmpty() || password.isEmpty()) {
      view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    if (authService.authenticate(user)) {
      view.showMessage("Login realizado com sucesso!", "Sucesso");
    } else {
      view.showMessage("Usuário ou senha incorretos.", "Erro");
    }
  }
}
