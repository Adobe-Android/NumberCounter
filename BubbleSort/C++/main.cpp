#include <iostream>
#include <iterator>

void BubbleSort(int intArr[], int n);
void PrintArray(int intArr[], int n);

int main()
{
    int intArr[]{38, 48, 89, 71, 87, 48, 97, 84, 39, 55};
    int n{std::size(intArr) - 1};
    BubbleSort(intArr, n);
    PrintArray(intArr, n);
    return 0;
}

void BubbleSort(int intArr[], int n)
{
    for (int i{0}; i < n; i++)
        for (int j{0}; j < n - i; j++)
            if (intArr[j] > intArr[j + 1])
            {
                int temp{intArr[j]};
                intArr[j] = intArr[j + 1];
                intArr[j + 1] = temp;
            }
}

void PrintArray(int intArr[], int n)
{
    for (int i{0}; i < n + 1; ++i)
        std::cout << intArr[i] << " ";
}
