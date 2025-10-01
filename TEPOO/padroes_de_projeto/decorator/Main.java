package TEPOO.padroes_de_projeto.decorator;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      LoginView view = new LoginView();
      new LoginController(view);
      view.setVisible(true);
    });
  }
}
