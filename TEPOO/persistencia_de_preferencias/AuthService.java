package TEPOO.persistencia_de_preferencias;

public class AuthService {
  public boolean authenticate(User user) {
    return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
  }
}
