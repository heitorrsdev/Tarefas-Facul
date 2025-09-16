package TEPOO.padroes_de_projeto;

public interface AuthStrategy {
    boolean authenticate(String username, String password);
}

