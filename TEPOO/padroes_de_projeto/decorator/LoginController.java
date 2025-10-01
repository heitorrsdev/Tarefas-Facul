package TEPOO.padroes_de_projeto.decorator;

public class LoginController {
  private LoginView view;

  public LoginController(LoginView view) {
    this.view = view;
    // Vincula a ação do botão da view ao método do controller
    view.setController(this);
  }

  public void handleLogin(String username, String password, boolean log) {
    if (username.isEmpty() || password.isEmpty()) {
      view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    User user = new User(username, password);
    IAuthService service = new RealAuthService();

    if (log) {
      service = new LoggingAuthDecorator(service);
    }

    if (service.authenticate(user)) {
      view.showMessage("Login realizado com sucesso!", "Sucesso");
    } else {
      view.showMessage("Usuário ou senha incorretos.", "Erro");
    }
  }
}
