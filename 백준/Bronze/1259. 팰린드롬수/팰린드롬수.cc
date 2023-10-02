#include<iostream>
#include<vector>
using namespace std;

int main(void) {
	string A;
	vector<string>answer;
	int k;
	while (1)
	{
		cin >> A;
		int cnt = 0;
		if (A=="0")
		{
			break;
		}
		if (A.size() % 2 == 0)
		{
			k = A.size() - 1;
			for (int i = 0; i < A.size(); i++)
			{
				if (A[i] != A[k])
				{
					cnt++;
					k--;
				}
				else
				{
					k--;
				}
			}
			if (cnt != 0)
			{
				answer.push_back("no");
			}
			else answer.push_back("yes");
		}
		else
		{
			k = A.size() - 1;
			for (int i = 0; i < A.size(); i++)
			{
				if (i==A.size()/2)
				{
					break;
				}
				if (A[i] != A[k])
				{
					cnt++; k--;
				}
				else k--;
			}
			if (cnt != 0)
			{
				answer.push_back("no");
			}
			else answer.push_back("yes");

		}
	}
	for (int i = 0; i < answer.size(); i++)
	{
		cout << answer[i] << endl;
	}
	return 0;
}
