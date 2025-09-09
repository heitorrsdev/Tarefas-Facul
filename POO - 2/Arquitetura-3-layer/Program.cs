using System;
using LojaProdutos.BLL;

namespace LojaProdutos.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            var produtoService = new ProdutoService();

            while (true)
            {
                Console.WriteLine("Digite a opção desejada:");
                Console.WriteLine("1. Adicionar Produto");
                Console.WriteLine("2. Listar Produtos");
                Console.WriteLine("3. Sair");
                var opcao = Console.ReadLine();

                if (opcao == "1")
                {
                    Console.WriteLine("Digite o nome do produto:");
                    var nomeProduto = Console.ReadLine();
                    if (!string.IsNullOrWhiteSpace(nomeProduto))
                    {
                        produtoService.AdicionarProduto(nomeProduto);
                    }
                    else
                    {
                        Console.WriteLine("Nome do produto não pode ser vazio.");
                    }
                }
                else if (opcao == "2")
                {
                    produtoService.ListarProdutos();
                }
                else if (opcao == "3")
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Opção inválida.");
                }
            }
        }
    }
}
