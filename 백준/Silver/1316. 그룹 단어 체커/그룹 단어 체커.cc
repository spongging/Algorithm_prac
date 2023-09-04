#include <iostream>
#include <string>
using namespace std;

int main() {

	int n;
	cin >> n;
	int result = 0;
	string A;
	for (int t = 0; t < n; t++)
	{
		cin >> A;
		bool c[26] = { false };
		c[(int)(A[0]-97)] = true;
		for (int  i = 1; i < A.size(); i++)
		{
			if (A[i]==A[i-1])
			{
				continue;
			}
			else if (A[i]!=A[i-1]&& c[(int)(A[i] - 97)] ==true)
			{
				result++;
				break;
			}
			else
			{
				c[(int)(A[i] - 97)] = true;
			}
		}
	}
	cout << n - result;

	return 0;
}