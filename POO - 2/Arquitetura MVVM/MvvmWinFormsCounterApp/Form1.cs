using System.Windows.Forms;

namespace MvvmWinFormsCounterApp
{
    public partial class Form1 : Form
    {
        private CounterViewModel _viewModel;

        public Form1()
        {
            InitializeComponent();
            _viewModel = new CounterViewModel();

            // Liga o rótulo à propriedade Count do ViewModel
            countLabel.DataBindings.Add("Text", _viewModel, "Count");

            // Liga os botões aos comandos no ViewModel
            incrementButton.Click += (sender, e) => _viewModel.IncrementCommand.Execute(null);
            decrementButton.Click += (sender, e) => _viewModel.DecrementCommand.Execute(null);
            resetButton.Click += (sender, e) => _viewModel.ResetCommand.Execute(null);
        }
    }
}
