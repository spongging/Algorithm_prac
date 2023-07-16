#include <iostream>
using namespace std;

int main()
{
	long long a;
	int i, hap = 0;
	cin >> a;
	for (i = 1; i <= a; i++)
	{
		hap += i;
	}
	cout << hap;
}


