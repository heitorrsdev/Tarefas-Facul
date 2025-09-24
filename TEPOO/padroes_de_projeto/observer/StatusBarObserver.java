package TEPOO.padroes_de_projeto.observer;

import javax.swing.JLabel;

public class StatusBarObserver implements LoginObserver {
  private JLabel statusLabel;

  public StatusBarObserver(JLabel statusLabel) {
    this.statusLabel = statusLabel;
  }

  @Override
  public void onLogin(boolean success) {
    if (!success) {
      statusLabel.setText("Status: Falha no login.");
      return;
    }
    statusLabel.setText("Status: Login bem-sucedido!");
  }
}
