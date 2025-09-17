package TEPOO.padroes_de_projeto.strategy;

public class LoginController {
  private AuthService authService;
  private LoginView view;

  public LoginController(AuthService authService, LoginView view) {
    this.authService = authService;
    this.view = view;

    view.setController(this);
  }

  public void handleLogin(String username, String password, String strategyType) {
    if (username.isEmpty() || password.isEmpty()) {
      view.showMessage("Usuário e senha não podem estar vazios.", "Erro");
      return;
    }

    AuthStrategy strategy;
    if ("SimpleAuth".equals(strategyType)) {
      strategy = new SimpleAuth();
    } else if ("RegexAuth".equals(strategyType)) {
      strategy = new RegexAuth();
    } else {
      view.showMessage("Estratégia de autenticação inválida.", "Erro");
      return;
    }

    authService.setStrategy(strategy);

    if (authService.authenticate(username, password)) {
      view.showMessage("Login realizado com sucesso!", "Sucesso");
    } else {
      view.showMessage("Usuário ou senha incorretos.", "Erro");
    }
  }
}
