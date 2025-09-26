package TEPOO.padroes_de_projeto.factory_method;

public class LoginScreenFactory extends ScreenFactory {
  @Override
  public Screen createScreen() {
    return new LoginScreen();
  }
}
