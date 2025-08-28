public class Banco {
  public static void main(String[] args) {
    // Criando duas contas
    Conta account1 = new Conta(123, "Ana Santos");
    Conta account2 = new Conta(456, "Bruno Alexandre");

    System.out.println();

    // Depósitos
    if (account1.deposit(500)) {
      System.out.println("Depósito na conta de " + account1.getOwner() + " realizado com sucesso.");
    }

    if (account2.deposit(300)) {
      System.out.println("Depósito na conta de " + account2.getOwner() + " realizado com sucesso.");
    }

    // Saques
    if (account1.withdraw(100)) {
      System.out.println("Saque realizado na conta de " + account1.getOwner());
    } else {
      System.out.println("Não foi possível sacar da conta de " + account1.getOwner());
    }

    if (account2.withdraw(700)) {
      System.out.println("Saque realizado na conta de " + account2.getOwner());
    } else {
      System.out.println("Não foi possível sacar da conta de " + account2.getOwner());
    }

    // Consultando saldos
    System.out.println(account1); // usa o toString()
    System.out.println(account2);
  }
}
