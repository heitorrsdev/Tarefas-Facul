public class Calculadora {
  public static void main(String[] args) {
    float number1 = 27;
    float number2 = 0;
    System.out.println("\nNúmeros: " + number1 + " e " + number2 + "\n");

    boolean divisionByZero = number2 == 0;

    float sum = number1 + number2;
    float subtraction = number1 - number2;
    float multiplication = number1 * number2;
    double division = divisionByZero ? 0 : number1 / number2;
    float nthRoot = (float) Math.pow(number1, 1 / number2);
    double power = divisionByZero ? 1 : Math.pow(number1, number2);

    System.out.println(
      "Resultados:\n" +
      "Soma: " + sum + "\n" +
      "Subtração: " + subtraction + "\n" +
      "Multiplicação: " + multiplication + "\n" +
      "Potência: " + power + "\n"
    );

    if( divisionByZero) {
      System.out.println("Raiz n-esima e divisão não podem ser calculadas com índice/divisor zero.\n");
    }
    else {
      System.out.println(
        "Divisão: " + division + "\n" +
        "Raiz n-esima: " + nthRoot + "\n"
      );
    }
  }
}
