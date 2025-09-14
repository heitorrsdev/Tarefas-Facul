package TEPOO.tratamento_de_excecoes_personalizadas;

public class SaldoInsuficienteException extends Exception {
  public SaldoInsuficienteException() {
    super("Saldo insuficiente para saque.");
  }
}
