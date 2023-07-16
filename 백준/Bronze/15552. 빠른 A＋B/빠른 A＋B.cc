#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

	long long t;
	int i;
	int a, b;
	cin >> t;
	for (i = 0; i < t; i++)
	{
		cin >> a >> b;
		cout << a + b << "\n";
	}

}

