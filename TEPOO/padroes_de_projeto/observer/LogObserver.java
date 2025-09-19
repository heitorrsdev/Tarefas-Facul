package TEPOO.padroes_de_projeto.observer;

public class LogObserver implements LoginObserver {
  @Override
  public void onLogin(boolean success) {
    if (!success) {
      System.out.println("Log: Usuário logado com sucesso.");
      return;
    }
    System.out.println("Log: Falha no login. Motivo: ");
  }
}
