public class ConversorTemperatura {

  public static double celsiusParaFahrenheit(double celsius) {
    // Fórmula: (°C × 9/5) + 32 = °F
    return (celsius * 9.0 / 5.0) + 32.0;
  }

  public static double fahrenheitParaCelsius(double fahrenheit) {
    // Fórmula: (°F − 32) × 5/9 = °C
    return (fahrenheit - 32.0) * 5.0 / 9.0;
  }

  public static double celsiusParaKelvin(double celsius) {
    // Fórmula: °C + 273.15 = K
    return celsius + 273.15;
  }

  public static void exibirTabela() {
    System.out.println("Tabela de Conversões (0°C a 100°C):");
    System.out.printf("%-10s %-15s %-15s%n", "Celsius", "Fahrenheit", "Kelvin");
    System.out.println("---------------------------------------------");

    for (int c = 0; c <= 100; c += 10) { // de 10 em 10 graus
      double f = celsiusParaFahrenheit(c);
      double k = celsiusParaKelvin(c);
      System.out.printf("%-10d %-15.2f %-15.2f%n", c, f, k);
    }
  }

  public static void main(String[] args) {
    // Testes básicos
    double c = 25.0;
    double f = celsiusParaFahrenheit(c);
    double k = celsiusParaKelvin(c);

    System.out.println("Conversões para" + c + "°C:");
    System.out.println("Fahrenheit: " + f);
    System.out.println("Kelvin: " + k);

    // Exibir tabela de 0°C a 100°C
    System.out.println();
    exibirTabela();
  }
}
