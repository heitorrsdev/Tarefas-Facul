package TEPOO.persistencia_de_preferencias;

// Classe auxiliar para carregar preferências
class Preferences {
  private String username;
  private boolean rememberMe;

  public Preferences(String username, boolean rememberMe) {
    this.username = username;
    this.rememberMe = rememberMe;
  }

  public String getUsername() {
    return username;
  }

  public boolean isRememberMe() {
    return rememberMe;
  }
}
