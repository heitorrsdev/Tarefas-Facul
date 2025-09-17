package TEPOO.padroes_de_projeto.strategy;

public class SimpleAuth implements AuthStrategy {
  @Override
  public boolean authenticate(String username, String password) {
    return username.equals("admin") && password.equals("123");
  }
}
