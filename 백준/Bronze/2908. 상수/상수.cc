#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
	char arr1[4];
	char arr2[4];
	int arr11, arr22;
	cin >> arr1 >> arr2;
	reverse(arr1, arr1 + 3);
	reverse(arr2, arr2 + 3);
	arr11 = atoi(arr1);
	arr22 = atoi(arr2);
	if (arr11>arr22)
	{
		cout << arr11;
	}
	else
	{
		cout << arr22;
	}
}

