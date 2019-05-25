#include <iostream>
#include <vector>

using std::cout;
using std::vector;

int main()
{
	long int_sum{0}; vector<int> sum_vector;
	for (int i{1}; i < 100'000'000; i++)
		if (i % 3 == 0 || i % 5 == 0)
			sum_vector.push_back({i});

	for (const int& j : sum_vector)
		int_sum += j;

	cout << int_sum << '\n';
}
