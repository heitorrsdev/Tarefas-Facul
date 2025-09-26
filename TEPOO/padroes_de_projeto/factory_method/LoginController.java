package TEPOO.padroes_de_projeto.factory_method;

public class LoginController {
  private AuthService authService;
  private LoginScreen view;

  public LoginController(AuthService authService, LoginScreen view) {
    this.authService = authService;
    this.view = view;

    view.setController(this);
    view.display();
  }

  public void handleLogin(String username, String password) {
    if (username.isEmpty() || password.isEmpty()) {
      this.view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    User user = new User(username, password);

    if (!authService.authenticate(user)) {
      this.view.showMessage("Usuário ou senha incorretos.", "Erro");
      return;
    }

    this.view.showMessage("Login bem sucedido!", "Sucesso");
    this.view.dispose();

    navigateToMainScreen();
  }

  protected void navigateToMainScreen() {
    ScreenFactory mainFactory = new MainScreenFactory();
    Screen mainScreen = mainFactory.createScreen();
    mainScreen.display();
  }
}
