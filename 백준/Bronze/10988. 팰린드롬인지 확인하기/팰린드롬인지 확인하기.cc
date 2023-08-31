#include <iostream>
using namespace std;

int main(void) {
	string A;
	cin >> A;
	int result = 1;
	for ( int i = 0; i < A.length()/2; i++)
	{
		if (A[i]==A[A.length()-1-i])
		{
			continue;
		}
		else
		{
			result = 0;
			break;
		}

	}
	if (result==1)
	{
		cout << 1;
	}
	else
	{
		cout << 0;
	}
}