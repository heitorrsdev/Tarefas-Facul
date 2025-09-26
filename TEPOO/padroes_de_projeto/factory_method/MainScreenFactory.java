package TEPOO.padroes_de_projeto.factory_method;

public class MainScreenFactory extends ScreenFactory {
  @Override
  public Screen createScreen() {
    return new MainScreen();
  }
}
