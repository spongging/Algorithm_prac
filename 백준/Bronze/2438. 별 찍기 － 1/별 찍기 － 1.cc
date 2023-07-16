#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
	
	int n;
	int j;
	int i = 1;
	cin >> n;
	while (i<=n)
	{
		for ( j = 1; j <= i; j++)
		{
			cout << "*";
		}
		cout << "\n";
		i++;
	}
}
