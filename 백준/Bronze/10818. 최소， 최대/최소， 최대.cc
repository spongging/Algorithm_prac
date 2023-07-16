#include <iostream>
#include <algorithm>

using namespace std;

int arr[1000001];

int main(void) 
{
	ios_base::sync_with_stdio(0);
	
	long long n, num;
	int i;
	cin >> n;
	for ( i = 0; i < n; i++)
	{
		cin >> num;
		arr[i] = num;
	}
	sort(arr, arr + n);
	cout << arr[0] << " " << arr[n - 1];

	
	return 0;
}
