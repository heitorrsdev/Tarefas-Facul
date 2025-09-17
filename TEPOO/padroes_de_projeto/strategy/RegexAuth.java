package TEPOO.padroes_de_projeto.strategy;


import java.util.regex.Pattern;

public class RegexAuth implements AuthStrategy {
  @Override
  public boolean authenticate(String username, String password) {
    // Usuário com 3+ caracteres, senha com 3+ caracteres
    return Pattern.matches(".{3,}", username) && Pattern.matches(".{3,}", password);
  }
}
