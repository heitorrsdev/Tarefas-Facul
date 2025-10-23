using System.ComponentModel;
using System.Windows.Input;

namespace MvvmWinFormsCounterApp
{
    public class CounterViewModel : INotifyPropertyChanged
    {
        private CounterModel _model;
        private int _count;

        public event PropertyChangedEventHandler? PropertyChanged;

        public CounterViewModel()
        {
            _model = new CounterModel();
            _count = _model.Count;

            IncrementCommand = new RelayCommand(Increment);
            DecrementCommand = new RelayCommand(Decrement);
            ResetCommand = new RelayCommand(Reset);
        }

        public int Count
        {
            get { return _count; }
            set
            {
                if (_count != value)
                {
                    _count = value;
                    OnPropertyChanged(nameof(Count));
                }
            }
        }

        public ICommand IncrementCommand { get; private set; }
        public ICommand DecrementCommand { get; private set; }
        public ICommand ResetCommand { get; private set; }

        private void Increment(object? parameter)
        {
            _model.Increment();
            Count = _model.Count;
        }

        private void Decrement(object? parameter)
        {
            _model.Decrement();
            Count = _model.Count;
        }

        private void Reset(object? parameter)
        {
            _model.Reset();
            Count = _model.Count;
        }

        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
