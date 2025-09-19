package TEPOO.padroes_de_projeto.observer;

public class Observable {
  private java.util.List<LoginObserver> observers = new java.util.ArrayList<>();

  public void addObserver(LoginObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(LoginObserver observer) {
    observers.remove(observer);
  }

  protected void notifyObservers(boolean sucess) {
    for (LoginObserver observer : observers) {
      observer.onLogin(sucess);
    }
  }
}
