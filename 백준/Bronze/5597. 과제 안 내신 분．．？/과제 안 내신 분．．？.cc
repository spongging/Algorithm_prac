#include <iostream>

using namespace std;

int main(void) 
{
	int i, n;
	int j;
	int arr[28];
	for (i = 0; i < 28; i++)
	{
		cin >> n;
		arr[i] = n;
	}
	for ( i = 1; i <= 30; i++)
	{
		j = 0;
		while (j < 29)
		{
			if (j == 28)
			{
				cout << i << endl;
				break;
			}
			if (i == arr[j])
			{
				break;
			}
			j++;
		}
	}
}