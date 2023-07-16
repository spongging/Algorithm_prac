#include <iostream>
#include <cstring>

using namespace std;

int main(void)
{
	int t;
	int len;
	int i;
	char arr[1001];
	cin >> t;
	for ( i = 0; i < t; i++)
	{
		cin >> arr;
		len = strlen(arr);
		cout << arr[0] << arr[len - 1] << endl;
	}
}
