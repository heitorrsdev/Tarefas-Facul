package TEPOO.implementacao_do_padrao_mvc;

public class AuthService {
  // Lógica de autenticação
  public boolean authenticate(User user) {
    return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
  }
}
