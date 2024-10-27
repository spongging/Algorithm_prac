#include <iostream>
#include <vector>
using namespace std;

int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int N;
	long long sum = 0;
	cin >> N;
	int* arr = new int[N];
	bool* dp = new bool[7];
	bool canGo = false;
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	for (int i = 0; i < 7; i++)
	{
		dp[i] = false;
	}
	dp[1] = true;
	for (int i = 0; i < N; i++)
	{
		vector<int> tempV;
		for (int j = 0; j < 7; j++)
		{
			if (dp[j] == true)
			{
				tempV.push_back(j);
			}
		}
		for (int j = 0; j < tempV.size(); j++)
		{
			dp[(tempV.at(j) + arr[i]) % 7] = true;
		}
		if (dp[5] == true)
		{
			canGo = true;
			break;
		}
	}
	if (canGo == true)
	{
		cout << "YES" << "\n";
	}
	else
	{
		cout << "NO" << "\n";
	}
	return 0;
}