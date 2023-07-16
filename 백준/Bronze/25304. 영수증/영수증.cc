#include <iostream>
using namespace std;

int main()
{
	long long x;
	int n, a, b, hap = 0;
	int i;
	cin >> x;
	cin >> n;
	for ( i = 0; i < n; i++)
	{
		cin >> a >> b;
		hap += a * b;
	}
	if (hap == x)
	{
		cout << "Yes";
	}
	else
	{
		cout << "No";
	}
}


