#include <iostream>
#include <vector>

using std::cout;
using std::vector;

int main()
{
    int i;
    int IntSum = 0;
    vector<int> sumVector;
    for (i = 1; i < 1000000; i++)
    {
        if (i % 3 == 0 || i % 5 == 0)
        {
            sumVector.push_back({i});
        }
    }
    for (const int &j : sumVector)
    {
        IntSum += j;
    }
    cout << IntSum << '\n';
    return 0;
}