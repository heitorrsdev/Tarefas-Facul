using System;
using System.Collections.Generic;
using System.IO;

namespace LojaProdutos.DAL_DS
{
    public class ProdutoRepository
    {
        private readonly string _filePath = "produtos.csv";  // Usando apenas o nome do arquivo

        // Salva a lista de produtos no arquivo CSV
        public void SalvarProdutos(List<string> produtos)
        {
            try
            {
                using (var writer = new StreamWriter(_filePath, false)) // sobrescreve o arquivo
                {
                    foreach (var produto in produtos)
                    {
                        writer.WriteLine(produto);  // Grava cada produto em uma linha
                    }
                }
                Console.WriteLine("Produtos salvos com sucesso!");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro ao salvar os produtos: {ex.Message}");
            }
        }

        // Carrega os produtos do arquivo CSV
        public List<string> CarregarProdutos()
        {
            var produtos = new List<string>();

            try
            {
                if (File.Exists(_filePath))  // Verifica se o arquivo existe
                {
                    using (var reader = new StreamReader(_filePath))
                    {
                        while (!reader.EndOfStream)
                        {
                            var linha = reader.ReadLine();  // Lê cada linha do arquivo
                            if (!string.IsNullOrWhiteSpace(linha))  // Ignora linhas vazias
                            {
                                produtos.Add(linha);  // Adiciona o produto à lista
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Erro ao carregar os produtos: {ex.Message}");
            }

            return produtos;
        }
    }
}
 
