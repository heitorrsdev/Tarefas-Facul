package TEPOO.padroes_de_projeto;

public class AuthService {
  private AuthStrategy strategy;

  public void setStrategy(AuthStrategy strategy) {
    this.strategy = strategy;
  }

  public boolean authenticate(String username, String password) {
    if (strategy == null) {
      throw new IllegalStateException("AuthStrategy não definida.");
    }
    return strategy.authenticate(username, password);
  }
}
