public class Banco {
  public static void main(String[] args) {
    // Criando duas contas
    Conta conta1 = new Conta(123, "Ana Santos");
    Conta conta2 = new Conta(456, "Bruno Alexandre");

    System.out.println();

    // Depósitos
    if (conta1.depositar(500)) {
      System.out.println("Depósito na conta de " + conta1.getTitular() + " realizado com sucesso.");
    }

    if (conta2.depositar(300)) {
      System.out.println("Depósito na conta de " + conta2.getTitular() + " realizado com sucesso.");
    }

    // Saques
    if (conta1.sacar(100)) {
      System.out.println("Saque realizado na conta de " + conta1.getTitular());
    } else {
      System.out.println("Não foi possível sacar da conta de " + conta1.getTitular());
    }

    if (conta2.sacar(700)) {
      System.out.println("Saque realizado na conta de " + conta2.getTitular());
    } else {
      System.out.println("Não foi possível sacar da conta de " + conta2.getTitular());
    }

    // Consultando saldos
    System.out.println(conta1); // usa o toString()
    System.out.println(conta2);
  }
}
