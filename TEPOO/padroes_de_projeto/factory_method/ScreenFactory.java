package TEPOO.padroes_de_projeto.factory_method;

public abstract class ScreenFactory {
  public abstract Screen createScreen();

  public void renderScreen() {
    Screen screen = createScreen();
    screen.display();
  }
}
