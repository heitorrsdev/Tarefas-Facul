package TEPOO.padroes_de_projeto.observer;

public class LoginSubject extends Observable {
  private AuthService authService;
  private LoginView view;

  public LoginSubject(AuthService authService, LoginView view) {
    this.authService = authService;
    this.view = view;

    view.setSubject(this);
  }

  public void handleLogin(String username, String password) {
    if (username.isEmpty() || password.isEmpty()) {
      view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    User user = new User(username, password);

    notifyObservers(authService.authenticate(user));
  }
}
