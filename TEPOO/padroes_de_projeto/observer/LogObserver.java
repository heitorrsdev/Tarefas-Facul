package TEPOO.padroes_de_projeto.observer;

import javax.swing.JTextArea;

public class LogObserver implements LoginObserver {
  private JTextArea logArea;

  public LogObserver(JTextArea logArea) {
    this.logArea = logArea;
  }

  @Override
  public void onLogin(boolean success) {
    if (!success) {
      logArea.append("Log: Falha no login.\n");
      return;
    }
    logArea.append("Log: Login bem-sucedido!\n");
  }
}
