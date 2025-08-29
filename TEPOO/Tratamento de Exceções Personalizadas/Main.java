public class Main {
  public static void main(String[] args) {
    ContaBancaria conta = new ContaBancaria(1000.0);

    try {
      System.out.println("\nSaldo inicial: " + conta.getSaldo());
      conta.sacar(600.0);

      System.out.println("Saldo após saque de 600: " + conta.getSaldo());
      conta.sacar(500.0); // Isso deve lançar a exceção

      System.out.println("Saldo após saque de 500: " + conta.getSaldo());
    } catch (SaldoInsuficienteException e) {
      System.out.println("Erro: " + e.getMessage());
    }

    System.out.println("Saldo final: " + conta.getSaldo());
  }
}
