package TEPOO.persistencia_de_preferencias;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      LoginView view = new LoginView();
      AuthService authService = new AuthService();
      PreferenceService preferenceService = new PreferenceService();
      new LoginController(authService, preferenceService, view);
      view.setVisible(true);
    });
  }
}
