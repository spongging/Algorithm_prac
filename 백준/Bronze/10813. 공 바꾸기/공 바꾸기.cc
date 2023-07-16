#include <iostream>

using namespace std;

int main(void) 
{
	int n, m, i;
	int a, b, temp;
	int arr[101];
	cin >> n >> m;
	for (i = 1; i <= n; i++)
	{
		arr[i - 1] = i;
	}
	for ( i = 0; i < m; i++)
	{
		cin >> a >> b;
		temp = arr[a-1];
		arr[a-1] = arr[b-1];
		arr[b - 1] = temp;

	}
	for ( i = 0; i < n; i++)
	{
		cout << arr[i] << " ";
	}
}


