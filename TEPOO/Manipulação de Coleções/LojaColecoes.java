import java.util.*;

public class LojaColecoes {
  private List<Produto> produtos = new ArrayList<>();
  private Map<String, List<Produto>> categorias = new HashMap<>();

  public void adicionarProduto(Produto produto) {
    produtos.add(produto);
  }

  public void removerProduto(Produto produto) {
    produtos.remove(produto);
  }

  public void listarProdutos() {
    if (produtos.isEmpty()) {
      System.out.println("Nenhum produto cadastrado.");
    } else {
      System.out.println("Produtos na loja:");
      for (Produto p : produtos) {
        System.out.println(p);
      }
    }
  }

  public void adicionarCategoria(String categoria, Produto produto) {
    categorias.computeIfAbsent(categoria, k -> new ArrayList<>()).add(produto);
  }

  public void listarProdutosPorCategoria(String categoria) {
    List<Produto> lista = categorias.get(categoria);
    if (lista == null || lista.isEmpty()) {
      System.out.println("Nenhum produto encontrado na categoria: " + categoria);
    } else {
      System.out.println("Produtos da categoria " + categoria + ":");
      for (Produto p : lista) {
        System.out.println(p);
      }
    }
  }
}
