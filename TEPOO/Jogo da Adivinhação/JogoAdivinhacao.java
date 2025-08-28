import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int secretNumber = random.nextInt(100) + 1;
    int attempts = 1;

    System.out.println("Bem-vindo ao Jogo da Adivinhação!");
    System.out.println("Tente adivinhar um número entre 1 e 100.");

    while (true) {
      try {
        System.out.print("Tentativa " + attempts + ": ");
        int guess = scanner.nextInt();
        attempts++;

        if (guess < 1 || guess > 100) {
          System.out.println("Por favor, escolha um número entre 1 e 100.");
        }

        if (guess < secretNumber) {
          System.out.println("O número secreto é maior que " + guess + ". Tente novamente.");
        } else if (guess > secretNumber) {
          System.out.println("O número secreto é menor que " + guess + ". Tente novamente.");
        } else {
          System.out.println(
              "Parabéns! Você adivinhou o número secreto "
                  + secretNumber
                  + " em "
                  + (attempts - 1)
                  + " tentativas.");
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
