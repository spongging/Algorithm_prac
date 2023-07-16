#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
	int i;
	char arr[16];
	int arr2[16];
	int num, cnt = 0;
	cin >> arr;
	for (i = 0; i < strlen(arr); i++)
	{
		if (arr[i]=='A' || arr[i] == 'B'|| arr[i] == 'C')
		{
			arr2[i] = 2;
		}
		else if (arr[i] == 'D' || arr[i] == 'E' || arr[i] == 'F')
		{
			arr2[i] = 3;
		}
		else if (arr[i] == 'G' || arr[i] == 'H' || arr[i] == 'I')
		{
			arr2[i] = 4;
		}
		else if (arr[i] == 'J' || arr[i] == 'K' || arr[i] == 'L')
		{
			arr2[i] = 5;
		}
		else if (arr[i] == 'M' || arr[i] == 'N' || arr[i] == 'O')
		{
			arr2[i] = 6;
		}
		else if (arr[i] == 'P' || arr[i] == 'Q' || arr[i] == 'R' || arr[i] == 'S')
		{
			arr2[i] = 7;
		}
		else if (arr[i] == 'T' || arr[i] == 'U' || arr[i] == 'V')
		{
			arr2[i] = 8;
		}
		else
		{
			arr2[i] = 9;
		}
	}
	for (i = 0; i < strlen(arr); i++)
	{
		num = arr2[i];
		cnt = cnt + (num + 1);
	}
	cout << cnt;
}
