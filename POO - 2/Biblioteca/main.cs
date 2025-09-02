using System;
using System.Collections.Generic;

namespace SistemaBiblioteca
{
    class Usuario
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        public Usuario(int id, string nome)
        {
            if (string.IsNullOrWhiteSpace(nome))
                throw new ArgumentException("Nome do usuário não pode ser vazio.");
            Id = id;
            Nome = nome;
        }

        public override string ToString()
        {
            return $"Usuário {Id}: {Nome}";
        }
    }

    class Livro
    {
        public int Id { get; private set; }
        public string Titulo { get; private set; }
        public bool Emprestado { get; private set; }
        public Usuario EmprestadoPara { get; private set; }
        public DateTime DataDevolucao { get; private set; }  // Nova propriedade

        public Livro(int id, string titulo)
        {
            if (string.IsNullOrWhiteSpace(titulo))
                throw new ArgumentException("Título do livro não pode ser vazio.");
            Id = id;
            Titulo = titulo;
            Emprestado = false;
            EmprestadoPara = null;
            DataDevolucao = DateTime.MinValue;
        }

        public void Emprestar(Usuario usuario)
        {
            if (usuario == null)
                throw new ArgumentNullException(nameof(usuario), "Usuário não pode ser nulo.");
            if (Emprestado)
                throw new InvalidOperationException("Livro já está emprestado.");
            Emprestado = true;
            EmprestadoPara = usuario;
            DataDevolucao = DateTime.Now.AddDays(7); // Empréstimo inicial de 7 dias
        }

        public void EstenderEmprestimo()
        {
            if (!Emprestado)
                throw new InvalidOperationException("Livro não está emprestado.");
            DataDevolucao = DataDevolucao.AddDays(7); // Extende 7 dias a partir da data atual de devolução
        }

        public void Devolver()
        {
            if (!Emprestado)
                throw new InvalidOperationException("Livro não está emprestado.");
            Emprestado = false;
            EmprestadoPara = null;
            DataDevolucao = DateTime.MinValue;
        }

        public override string ToString()
        {
            string status = Emprestado 
                ? $"Emprestado para {EmprestadoPara.Nome} até {DataDevolucao:dd/MM/yyyy}" 
                : "Disponível";
            return $"Livro {Id}: {Titulo} - {status}";
        }
    }

    class Biblioteca
    {
        private Dictionary<int, Usuario> usuarios = new Dictionary<int, Usuario>();
        private Dictionary<int, Livro> livros = new Dictionary<int, Livro>();

        public void EmprestarLivro(int idLivro, int idUsuario)
        {
            if (!livros.ContainsKey(idLivro))
                throw new KeyNotFoundException("Livro não encontrado.");
            if (!usuarios.ContainsKey(idUsuario))
                throw new KeyNotFoundException("Usuário não encontrado.");

            var livro = livros[idLivro];
            var usuario = usuarios[idUsuario];

            if (livro.Emprestado)
            {
                if (livro.EmprestadoPara.Id == idUsuario)
                {
                    Console.WriteLine($"Você já tem este livro emprestado até {livro.DataDevolucao:dd/MM/yyyy}.");
                    Console.Write("Deseja estender o empréstimo por mais 1 semana? (s/n): ");
                    string resposta = Console.ReadLine().Trim().ToLower();
                    if (resposta == "s" || resposta == "sim")
                    {
                        livro.EstenderEmprestimo();
                        Console.WriteLine($"Empréstimo estendido! Nova data de devolução: {livro.DataDevolucao:dd/MM/yyyy}");
                    }
                    else
                    {
                        Console.WriteLine("Empréstimo não foi estendido.");
                    }
                    return;
                }
                else
                {
                    throw new InvalidOperationException("Livro já está emprestado para outro usuário.");
                }
            }

            livro.Emprestar(usuario);
        }

        public void DevolverLivro(int idLivro)
        {
            if (!livros.ContainsKey(idLivro))
                throw new KeyNotFoundException("Livro não encontrado.");
            livros[idLivro].Devolver();
        }

        public void ListarLivros()
        {
            Console.WriteLine("Livros:");
            foreach (var l in livros.Values)
            {
                Console.WriteLine(l);
            }
        }

        internal void InicializarDados()
        {
            usuarios.Add(1, new Usuario(1, "Alice"));
            usuarios.Add(2, new Usuario(2, "Bob"));

            livros.Add(1, new Livro(1, "1984"));
            livros.Add(2, new Livro(2, "O Senhor dos Anéis"));
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Biblioteca biblioteca = new Biblioteca();

            biblioteca.InicializarDados();

            Console.WriteLine("Bem-vindo ao Sistema da Biblioteca!");

            bool sair = false;
            while (!sair)
            {
                Console.WriteLine("\nEscolha uma opção:\n");
                Console.WriteLine("1 - Listar livros\n");
                Console.WriteLine("2 - Emprestar livro\n");
                Console.WriteLine("3 - Devolver livro\n");
                Console.WriteLine("0 - Sair\n");
                Console.Write("Opção: ");

                string opcao = Console.ReadLine();

                try
                {
                    switch (opcao)
                    {
                        case "1":
                            biblioteca.ListarLivros();
                            break;

                        case "2":
                            Console.Write("Digite o ID do livro a emprestar: ");
                            int idLivroEmp = int.Parse(Console.ReadLine());
                            Console.Write("Digite o ID do usuário que vai pegar o livro: ");
                            int idUsuarioEmp = int.Parse(Console.ReadLine());
                            biblioteca.EmprestarLivro(idLivroEmp, idUsuarioEmp);
                            Console.WriteLine("Operação concluída.");
                            break;

                        case "3":
                            Console.Write("Digite o ID do livro a devolver: ");
                            int idLivroDev = int.Parse(Console.ReadLine());
                            biblioteca.DevolverLivro(idLivroDev);
                            Console.WriteLine("Livro devolvido com sucesso.");
                            break;

                        case "0":
                            sair = true;
                            Console.WriteLine("Saindo do sistema. Até logo!");
                            break;

                        default:
                            Console.WriteLine("Opção inválida. Tente novamente.");
                            break;
                    }
                }
                catch (FormatException)
                {
                    Console.WriteLine("Entrada inválida. Por favor, digite um número válido.");
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Erro: {ex.Message}");
                }
            }
        }
    }
}
