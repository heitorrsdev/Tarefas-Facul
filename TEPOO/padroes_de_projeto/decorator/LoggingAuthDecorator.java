package TEPOO.padroes_de_projeto.decorator;

public class LoggingAuthDecorator implements IAuthService {
  private IAuthService delegate;

  public LoggingAuthDecorator(IAuthService authService) {
    this.delegate = authService;
  }

  public boolean authenticate(User user) {
    long startTime = System.nanoTime();

    System.out.println("[" + java.time.LocalDateTime.now() + "]");
    System.out.println("Tentativa de login para o usuário: " + user.getUsername());

    boolean result = delegate.authenticate(user);
    System.out.println("Resultado da autenticação: " + (result ? "SUCESSO" : "FALHA"));

    long endTime = System.nanoTime();
    long durationMs = (endTime - startTime) / 1_000_000;
    System.out.println("Tempo de execução: " + durationMs + " ms");
    return result;
  }
}
