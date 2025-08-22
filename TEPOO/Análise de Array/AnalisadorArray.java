public class AnalisadorArray {
  public static void main(String[] args) {
    int[] numeros = {23, 45, 12, 67, 89, 34, 56, 78, 90, 12};

    System.out.println("\nArray original:");
    exibirArray(numeros);

    // Implemente as análises aqui

    System.out.println("\nArray ordenado:");
    ordenarArray(numeros);
    exibirArray(numeros);
  }

  public static void exibirArray(int[] arr) {
    // Implemente a exibição
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void ordenarArray(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          // Troca os elementos
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
