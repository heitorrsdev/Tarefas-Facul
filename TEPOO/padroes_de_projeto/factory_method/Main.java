package TEPOO.padroes_de_projeto.factory_method;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      ScreenFactory factory = new LoginScreenFactory();
      LoginScreen view = ((LoginScreen) factory.createScreen());
      AuthService service = new AuthService();
      new LoginController(service, view);
      view.display();;
    });
  }
}
