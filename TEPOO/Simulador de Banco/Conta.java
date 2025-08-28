public class Conta {
  private int number;
  private String owner;
  private double balance;

  // Construtor
  public Conta(int number, String owner) {
    this.number = number;
    this.owner = owner;
    this.balance = 0.0;
  }

  public boolean deposit(double value) {
    if (value > 0) {
      balance += value;
      return true;
    }
    return false;
  }

  public boolean withdraw(double value) {
    if (value > 0 && value <= balance) {
      balance -= value;
      return true;
    }
    return false;
  }

  // Getters e Setters
  public int getNumber() {
    return number;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public double getBalance() {
    return balance;
  }

  // Representação em texto (opcional, útil para debug)
  @Override
  public String toString() {
    return "Conta N° "
        + number
        + " | Titular: "
        + owner
        + " | Saldo: R$ "
        + String.format("%.2f", balance);
  }
}
