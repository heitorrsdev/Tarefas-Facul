namespace MvvmWinFormsCounterApp
{
    public class CounterModel
    {
        public int Count { get; private set; }

        public CounterModel()
        {
            Count = 0;
        }

        public void Increment()
        {
            Count++;
        }

        public void Decrement()
        {
            Count--;
        }

        public void Reset()
        {
            Count = 0;
        }
    }
}
