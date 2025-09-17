package TEPOO.padroes_de_projeto.strategy;

public interface AuthStrategy {
    boolean authenticate(String username, String password);
}

