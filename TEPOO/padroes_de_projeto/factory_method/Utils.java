package TEPOO.padroes_de_projeto.factory_method;

public class Utils {
  public static void setFontRecursively(java.awt.Component component, java.awt.Font font) {
    component.setFont(font);
    if (component instanceof java.awt.Container) {
      for (java.awt.Component child : ((java.awt.Container) component).getComponents()) {
        setFontRecursively(child, font);
      }
    }
  }
}
