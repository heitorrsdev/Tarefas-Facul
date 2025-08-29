public class Main {
  public static void main(String[] args) {
    LojaColecoes loja = new LojaColecoes();

    // Criando produtos
    Produto p1 = new Produto("Notebook", 3500.0);
    Produto p2 = new Produto("Mouse", 80.0);
    Produto p3 = new Produto("Teclado", 200.0);
    Produto p4 = new Produto("Camiseta", 50.0);
    Produto p5 = new Produto("Calça", 120.0);

    // Adicionando produtos na loja
    loja.adicionarProduto(p1);
    loja.adicionarProduto(p2);
    loja.adicionarProduto(p3);
    loja.adicionarProduto(p4);
    loja.adicionarProduto(p5);

    // Listando todos os produtos
    loja.listarProdutos();

    System.out.println("\n--- Removendo o Mouse ---");
    loja.removerProduto(p2);
    loja.listarProdutos();

    // Adicionando produtos em categorias
    loja.adicionarCategoria("Eletrônicos", p1);
    loja.adicionarCategoria("Eletrônicos", p3);
    loja.adicionarCategoria("Roupas", p4);
    loja.adicionarCategoria("Roupas", p5);

    System.out.println("\n--- Listando por categoria ---");
    loja.listarProdutosPorCategoria("Eletrônicos");
    loja.listarProdutosPorCategoria("Roupas");
    loja.listarProdutosPorCategoria("Alimentos"); // categoria inexistente
  }
}
