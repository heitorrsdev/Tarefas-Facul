public class Loja {
  public static void main(String[] args) {
    Funcionario gerente = new Gerente("Diogo", 8000);
    Funcionario vendedor = new Vendedor("Letícia", 4000);
    System.out.println("\nBem-vindo ao sistema de relatório de funcionários!\n");

    System.out.println("Gerente: " + gerente.getNome() +
    ", Salário: R$" + gerente.getSalario() +
    ", Bônus: R$" + gerente.calcularBonus());
    
    System.out.println("Vendedor: " + vendedor.getNome() +
    ", Salário: R$" + vendedor.getSalario() +
    ", Bônus: R$" + vendedor.calcularBonus());

    System.out.println("Este mês o gerente receberá um bônus, totalizando um ganho de: R$" +
    (gerente.getSalario() + gerente.calcularBonus()));
  }
}
