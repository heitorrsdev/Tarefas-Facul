using System;
using System.Collections.Generic;
using LojaProdutos.DAL_DS;

namespace LojaProdutos.BLL
{
    public class ProdutoService
    {
        private readonly ProdutoRepository _produtoRepository;

        public ProdutoService()
        {
            _produtoRepository = new ProdutoRepository();
        }

        // Método para adicionar um produto
        public void AdicionarProduto(string produto)
        {
            var produtos = _produtoRepository.CarregarProdutos();  // Carrega os produtos atuais
            produtos.Add(produto);  // Adiciona o novo produto
            _produtoRepository.SalvarProdutos(produtos);  // Salva a lista atualizada
        }

        // Método para listar todos os produtos
        public void ListarProdutos()
        {
            var produtos = _produtoRepository.CarregarProdutos();
            if (produtos.Count > 0)
            {
                Console.WriteLine("Lista de Produtos:");
                foreach (var produto in produtos)
                {
                    Console.WriteLine($"- {produto}");
                }
            }
            else
            {
                Console.WriteLine("Nenhum produto encontrado.");
            }
        }
    }
}
