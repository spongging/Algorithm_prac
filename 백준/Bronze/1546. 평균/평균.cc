#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int n, i;
	int a, b=0;
	double arr[1001];
	double M, result;
	cin >> n;
	for ( i = 0; i < n; i++)
	{
		cin >> a;
		arr[i] = a;
	}
	sort(arr, arr + n);
	for ( i = 0; i < n; i++)
	{
		b += arr[i];
		M = arr[n - 1];
	}
	
	cout << fixed;
	cout.precision(6);
	result = (b / M * 100) / n;
	cout << result;

}
