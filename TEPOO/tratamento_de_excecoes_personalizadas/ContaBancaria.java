package TEPOO.tratamento_de_excecoes_personalizadas;

public class ContaBancaria {
  private double saldo;

  public ContaBancaria(double saldoInicial) {
    this.saldo = saldoInicial;
  }

  public void depositar(double valor) {
    saldo += valor;
  }

  public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor > saldo) {
      throw new SaldoInsuficienteException();
    }
    saldo -= valor;
  }

  public double getSaldo() {
    return saldo;
  }
}
