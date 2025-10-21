using System;

namespace ConsoleMVVM
{
    // Model
    public class ContadorModel
    {
        public int Valor { get; set; } = 0;
    }

    // ViewModel
    public class ContadorViewModel
    {
        private ContadorModel _model;

        public ContadorViewModel(ContadorModel model)
        {
            _model = model;
        }

        public int Contador => _model.Valor;

        public void Aumentar()
        {
            _model.Valor++;
        }

        public void Diminuir()
        {
            _model.Valor--;
        }

        public void Zerar()
        {
            _model.Valor = 0;
        }
    }

    // View (Terminal)
    class Program // tirar essa parte e fazer em HTML
    {
        static void Main(string[] args)
        {
            var model = new ContadorModel();
            var viewModel = new ContadorViewModel(model);

            while (true)
            {
                Console.Clear();
                Console.WriteLine("Contador atual: " + viewModel.Contador);
                Console.WriteLine("Escolha uma opção:");
                Console.WriteLine("1 - Aumentar contador");
                Console.WriteLine("2 - Diminuir contador");
                Console.WriteLine("3 - Zerar contador");
                Console.WriteLine("0 - Sair");

                Console.Write("Opção: ");
                string input = Console.ReadLine();

                switch (input)
                {
                    case "1":
                        viewModel.Aumentar();
                        break;
                    case "2":
                        viewModel.Diminuir();
                        break;
                    case "3":
                        viewModel.Zerar();
                        break;
                    case "0":
                        return;
                    default:
                        Console.WriteLine("Opção inválida! Pressione Enter para tentar novamente...");
                        Console.ReadLine();
                        break;
                }
            }
        }
    }
}
