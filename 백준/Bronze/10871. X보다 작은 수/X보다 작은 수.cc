#include <iostream>
using namespace std;

int main() 
{
	int i, num;
	int arr[10001];
	long long x, n;
	cin >> n >> x;
	for (i = 0; i < n; i++)
	{
		cin >> num;
		arr[i] = num;
	}
	for (i = 0; i < n; i++)
	{
		if (arr[i] < x)
		{
			cout << arr[i]<<" ";
		}
	}


}