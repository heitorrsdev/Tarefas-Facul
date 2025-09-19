package TEPOO.padroes_de_projeto.observer;

public class StatusBarObserver implements LoginObserver {
  @Override
  public void onLogin(boolean success) {
    if (!success) {
      System.out.println("StatusBar: Falha no login.");
      return;
    }
    System.out.println("StatusBar: Login bem-sucedido!");
  }
}
