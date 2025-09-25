package TEPOO.padroes_de_projeto.factory_method;

public class AuthService {
  // Lógica de autenticação
  public boolean authenticate(User user) {
    return "admin".equals(user.getUsername()) && "123".equals(user.getPassword());
  }
}
