#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int n, m, j;
	int i, a, b;
	int arr[101];
	int arr2[101];
	cin >> n >> m;
	for (i = 1; i <= n; i++)
	{
		arr[i] = i;
	}
	for ( i = 0; i < m; i++)
	{
		cin >> a >> b;
		for (j = 0; j <= (b - a) / 2; j++)
		{
			swap(arr[j + a], arr[b - j]);
		}

	}
	for ( i = 1; i <= n; i++)
	{
		cout << arr[i] << " ";
	}
}
