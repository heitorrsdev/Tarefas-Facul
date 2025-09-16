using System;
using System.Collections.Generic;

namespace CaixaDeMercado
{
    // Camada de Acesso a Dados - Produto
    public class Produto
    {
        public string Nome { get; set; }
        public decimal Preco { get; set; }

        public Produto(string nome, decimal preco)
        {
            Nome = nome;
            Preco = preco;
        }
    }
}
