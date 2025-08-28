public class Vendedor extends Funcionario {
  public Vendedor(String nome, double salario) {
    super(nome, salario);
  }

  @Override
  public double calcularBonus() {
    return this.getSalario() * 0.15;
  }
  
}
