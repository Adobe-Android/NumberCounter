using System;

namespace BubbleSort
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] intArr =
            {
                708, 386, 862, 524, 587,
                893, 994, 274, 640, 560,
                389, 957, 264, 726, 801,
                717, 525, 764, 905, 528,
                644, 710, 969, 919, 714,
                997, 387, 48, 434, 98,
                690, 107, 85, 895, 4,
                123, 701, 243, 342, 745,
                106, 801, 740, 696, 361,
                642, 395, 222, 524, 304,
                249, 942, 202, 700, 80,
                398, 305, 558, 362, 194,
                394, 528, 529, 68, 941,
                241, 517, 299, 222, 792,
                142, 1000, 118, 699, 959,
                384, 179, 541, 462, 331,
                5, 711, 950, 783, 108,
                339, 122, 42, 329, 653,
                483, 247, 320, 461, 716,
                545, 740, 76, 373, 719
            };
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
