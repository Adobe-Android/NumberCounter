using System;

namespace BubbleSort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] intArr = { 38, 48, 89, 71, 87, 48, 97, 84, 39, 55};
            BubbleSort(intArr);
            PrintArray(intArr);
        }

        static void BubbleSort(int[] intArr)
        {
            int n = intArr.Length - 1;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n - i; j++)
                    if (intArr[j] > intArr[j + 1])
                    {
                        int temp = intArr[j];
                        intArr[j] = intArr[j + 1];
                        intArr[j + 1] = temp;
                    }
        }

        static void PrintArray(int[] intArr)
        {
            int n = intArr.Length;
            for (int i = 0; i < n; ++i)
                Console.Write(intArr[i] + " ");
        }
    }
}
