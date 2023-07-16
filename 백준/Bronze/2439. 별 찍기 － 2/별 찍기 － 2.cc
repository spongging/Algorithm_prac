#include <iostream>

using namespace std;
int main()
{
	int n;
	int nn;
	int i = 1;
	int j;
	int z;
	cin >> n;
	while (i <= n)
	{

		nn = n - i;
		for (j = 1; j <= nn; j++)
		{
			cout << " ";
		}
		for (z = i; z > 0; z--)
		{
			cout << "*";
		}
		cout << "\n";
		i++;
	}
	
}