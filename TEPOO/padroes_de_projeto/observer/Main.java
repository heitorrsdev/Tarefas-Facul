package TEPOO.padroes_de_projeto.observer;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      LoginView view = new LoginView();
      AuthService service = new AuthService();
      new LoginSubject(service, view);
      view.setVisible(true);

      // Adiciona os observers aqui, onde o subject é instanciado
      view.getSubject().addObserver(new LogObserver(view.getLogArea()));
      view.getSubject().addObserver(new StatusBarObserver(view.getStatusLabel()));
    });
  }
}
