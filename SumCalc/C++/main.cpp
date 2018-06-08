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
        // cout << "The count is " << i << '\n';
        if (i % 3 == 0 || i % 5 == 0)
        {
            cout << "Divisible by 3 or 5 " << i << '\n';
            sumVector.push_back({i});
        }
    }
    for (const int &j : sumVector)
    {
        // cout << j << ' ';
        IntSum += j;
    }
    /*
    for (vector<int>::const_iterator j = sum.begin(); j != sum.end(); ++j)
    {
        cout << *j << ' ';
        IntSum += *j;
    }
    */
    cout << IntSum << '\n';
    return 0;
}
