#include <iostream>

using namespace std;

int main(void) 
{
	int n, i;
	int max, max_location;
	int arr[9];
	for (i = 0; i < 9; i++)
	{
		cin >> n;
		arr[i] = n;
	}
	max = arr[0];
	max_location = 1;
	for (i = 0; i < 9; i++)
	{
		if (max<arr[i])
		{
			max = arr[i];
			max_location = i + 1;
		}
	}
	cout << max << endl;
	cout<< max_location;
	return 0;
}
