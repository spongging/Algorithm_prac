#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int main(void)
{
	int n, n2, j, z;
	int i, len;
	char arr[21];
	cin >> n;
	for (z = 0; z < n; z++)
	{
		cin >> n2 >> arr;
		len = strlen(arr);
		for (i = 0; i < len; i++)
		{
			for (j = 0; j < n2; j++)
			{
				cout << arr[i];
			}
		}
		cout << endl;
	}
}
