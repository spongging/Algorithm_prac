#include <iostream>
#include <algorithm>

using namespace std;

int main(void) 
{
	int n, m, i;
	int j, k;
	int o, l;
	int arr[101];
	cin >> n >> m;
	for ( i = 0; i < n; i++)
	{
		arr[i] = 0;
	}
	for ( i = 0; i < m; i++)
	{
		cin >> j >> k >> o;
		for (l = j - 1; l < k; l++)
		{
			arr[l] = o;
		}
	}
	for ( l = 0; l < n; l++)
	{
		cout << arr[l] << " ";
	}
	return 0;
}

