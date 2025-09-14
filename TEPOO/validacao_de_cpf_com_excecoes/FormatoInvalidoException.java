package TEPOO.validacao_de_cpf_com_excecoes;

public class FormatoInvalidoException extends Exception {
  public FormatoInvalidoException() {
    super("Erro! Formato de CPF inválido.");
  }
}
