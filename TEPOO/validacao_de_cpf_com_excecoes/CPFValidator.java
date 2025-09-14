package TEPOO.validacao_de_cpf_com_excecoes;

import java.util.Scanner;

public class CPFValidator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("\nDigite o CPF (somente números): ");
    String cpf = scanner.nextLine().replaceAll("\\D", ""); // Remove qualquer caractere que não seja número

    try {
      if (isValidCPF(cpf)) {
        System.out.println("CPF válido!");
      } else {
        System.out.println("CPF inválido!");
      }
    } catch (FormatoInvalidoException e) {
      System.out.println(e.getMessage()); // Exibe a mensagem da exceção
    }

    scanner.close();
  }

  public static boolean isValidCPF(String cpf) throws FormatoInvalidoException {
    if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
      throw new FormatoInvalidoException();
    }

    int firstDigit = calculateDigit(cpf, 9);
    int secondDigit = calculateDigit(cpf, 10);

    return firstDigit == Character.getNumericValue(cpf.charAt(9))
        && secondDigit == Character.getNumericValue(cpf.charAt(10));
  }

  private static int calculateDigit(String cpf, int length) {
    int sum = 0;
    int weight = length + 1;

    for (int i = 0; i < length; i++) {
      sum += Character.getNumericValue(cpf.charAt(i)) * weight--;
    }

    int remainder = sum % 11;
    return (remainder < 2) ? 0 : 11 - remainder;
  }
}
