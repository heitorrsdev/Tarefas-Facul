public class Conta {
  private int numero;
  private String titular;
  private double saldo;

  // Construtor
  public Conta(int numero, String titular) {
    this.numero = numero;
    this.titular = titular;
    this.saldo = 0.0;
  }

  public boolean depositar(double valor) {
    if (valor > 0) {
      saldo += valor;
      return true;
    }
    return false;
  }

  public boolean sacar(double valor) {
    if (valor > 0 && valor <= saldo) {
      saldo -= valor;
      return true;
    }
    return false;
  }

  // Getters e Setters
  public int getNumero() {
    return numero;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public double getSaldo() {
    return saldo;
  }

  // Representação em texto (opcional, útil para debug)
  @Override
  public String toString() {
    return "Conta Nº "
        + numero
        + " | Titular: "
        + titular
        + " | Saldo: R$ "
        + String.format("%.2f", saldo);
  }
}
