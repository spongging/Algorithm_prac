#include <iostream>
#include <vector>

using namespace std;

int func(int n) {
	vector<int>sum(n + 1);
	if (n == 0) return 0;
	else if (n == 1) return 1;
	else
	{
		sum[0] = 0; sum[1] = 1;
		for ( int i = 2;  i <= n;  i++)
		{
			sum[i] = sum[i - 1] + sum[i - 2];
		}
		return sum[n];
	}
}


int main(void) {
	int n, result;
	cin >> n;
	result = func(n);
	cout << result << endl;
	return 0;
}