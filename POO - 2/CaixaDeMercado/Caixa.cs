using System;
using System.Collections.Generic;

namespace CaixaDeMercado
{
    // Camada de Negócio - Caixa
    public class Caixa
    {
        public List<Produto> Produtos { get; set; }
        public decimal TotalCompra { get; private set; }
        public decimal Troco { get; private set; }

        public Caixa()
        {
            Produtos = new List<Produto>();
            TotalCompra = 0;
            Troco = 0;
        }

        public void AdicionarProduto(string nome, decimal preco)
        {
            Produtos.Add(new Produto(nome, preco));
            TotalCompra += preco;
        }

        public decimal CalcularTotal()
        {
            return TotalCompra;
        }

        public void ProcessarPagamento(decimal valorPago, string formaPagamento)
        {
            if (formaPagamento == "dinheiro" && valorPago < TotalCompra)
            {
                throw new Exception("Valor insuficiente para pagamento em dinheiro.");
            }

            if (formaPagamento == "dinheiro")
            {
                Troco = valorPago - TotalCompra;
            }
        }
    }
}
