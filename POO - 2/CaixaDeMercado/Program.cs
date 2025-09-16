using System;
using System.Collections.Generic;

namespace CaixaDeMercado
{
    public class Program
    {
        static void Main(string[] args)
        {
            var caixa = new Caixa();
            string nomeProduto;
            decimal precoProduto;
            string formaPagamento;
            decimal valorPago;

            Console.WriteLine("Bem-vindo ao sistema de Caixa de Mercado!");

            // Recebendo produtos
            while (true)
            {
                Console.Write("Digite o nome do produto (ou 'fim' para terminar): ");
                nomeProduto = Console.ReadLine();

                if (nomeProduto.ToLower() == "fim")
                    break;

                Console.Write("Digite o valor de venda do produto: ");
                if (decimal.TryParse(Console.ReadLine(), out precoProduto))
                {
                    caixa.AdicionarProduto(nomeProduto, precoProduto);
                    Console.WriteLine($"Produto {nomeProduto} adicionado com sucesso.");
                }
                else
                {
                    Console.WriteLine("Valor inválido, tente novamente.");
                }
            }

            // Exibindo o total da compra
            Console.WriteLine($"\nTotal da compra: R${caixa.CalcularTotal():0.00}");

            // Selecionando forma de pagamento
            Console.WriteLine("\nEscolha a forma de pagamento:");
            Console.WriteLine("1 - Cartão de Débito");
            Console.WriteLine("2 - Cartão de Crédito");
            Console.WriteLine("3 - PIX");
            Console.WriteLine("4 - Dinheiro");

            formaPagamento = Console.ReadLine().ToLower();
            while (formaPagamento != "1" && formaPagamento != "2" && formaPagamento != "3" && formaPagamento != "4")
            {
                Console.WriteLine("Opção inválida, escolha novamente.");
                formaPagamento = Console.ReadLine().ToLower();
            }

            if (formaPagamento == "4")
            {
                // Pagamento em dinheiro
                Console.Write("Digite o valor pago em dinheiro: ");
                if (decimal.TryParse(Console.ReadLine(), out valorPago))
                {
                    try
                    {
                        caixa.ProcessarPagamento(valorPago, "dinheiro");
                        Console.WriteLine($"Troco: R${caixa.Troco:0.00}");
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                }
                else
                {
                    Console.WriteLine("Valor inválido para pagamento em dinheiro.");
                }
            }
            else
            {
               
                Console.WriteLine("Pagamento aprovado!");
            }

            Console.WriteLine("\nObrigado por utilizar o sistema de Caixa de Mercado!");
        }
    }
}
