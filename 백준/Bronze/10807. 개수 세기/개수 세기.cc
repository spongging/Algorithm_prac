#include <iostream>
using namespace std;

int main() 
{
	int n;
	int i;
	int nn;
	int v, cnt = 0;
	int arr[101];
	cin >> n;
	for (i = 0; i < n; i++)
	{
		cin >> nn;
		arr[i] = nn;
	}
	cin >> v;
	for ( i = 0; i < n; i++)
	{
		if (arr[i] == v)
		{
			cnt++;
		}
	}
	cout << cnt;
}