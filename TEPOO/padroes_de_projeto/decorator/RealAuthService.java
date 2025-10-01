package TEPOO.padroes_de_projeto.decorator;

public class RealAuthService implements IAuthService {
  @Override
  public boolean authenticate(User user) {
    return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
  }
}
