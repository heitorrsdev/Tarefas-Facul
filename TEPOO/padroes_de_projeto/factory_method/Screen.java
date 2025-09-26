package TEPOO.padroes_de_projeto.factory_method;

public interface Screen {
  public void display();

  // As funções abaixo foram adicionadas para evitar erros de compilação

  public default void setController(LoginController controller) {
    // Implementação padrão (pode ser vazia)
  }

  public default void showMessage(String message, String title) {}

  public default void dispose() {}
  
  public default void setVisible(boolean visible) {}
}
