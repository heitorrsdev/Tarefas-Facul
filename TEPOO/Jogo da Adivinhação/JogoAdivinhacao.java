import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int numeroSecreto = random.nextInt(100) + 1;
    int tentativas = 1;

    System.out.println("Bem-vindo ao Jogo da Adivinhação!");
    System.out.println("Tente adivinhar um número entre 1 e 100.");

    while (true) {
      try {
        System.out.print("Tentativa " + tentativas + ": ");
        int chute = scanner.nextInt();
        tentativas++;

        if (chute < 1 || chute > 100) {
          System.out.println("Por favor, escolha um número entre 1 e 100.");
        }

        if (chute < numeroSecreto) {
          System.out.println("O número secreto é maior que " + chute + ". Tente novamente.");
        } else if (chute > numeroSecreto) {
          System.out.println("O número secreto é menor que " + chute + ". Tente novamente.");
        } else {
          System.out.println("Parabéns! Você adivinhou o número secreto " + numeroSecreto +
              " em " + (tentativas - 1) + " tentativas.");
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Erro: por favor, digite um número.");
        scanner.next(); // Limpa a entrada inválida
      }
    }
    
    scanner.close();
  }
}
