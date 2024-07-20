#include <iostream>
#include <climits>
using namespace std;
int arr[1001][1001];
int dp[1001][1001];
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	int result = INT_MAX;

	for (int i = 0; i < N ; i++)
	{
		for (int j = 0; j < 3 ; j++)
		{
			int num; cin >> num; 
			arr[i][j] = num; 
		}
	}

	dp[0][0] = arr[0][0];
	dp[0][1] = arr[0][1];
	dp[0][2] = arr[0][2];

	for (int i = 1; i < N; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (j == 0) {
				dp[i][j] = min(arr[i][j] + dp[i - 1][1], arr[i][j] + dp[i - 1][2]);
			}
			else if (j==1)
			{
				dp[i][j] = min(arr[i][j] + dp[i - 1][0], arr[i][j] + dp[i - 1][2]);
			}
			else
			{
				dp[i][j] = min(arr[i][j] + dp[i - 1][0], arr[i][j] + dp[i - 1][1]);
			}
		}
	}
	for (int i = 0; i < 3; i++)
	{
		result = min(result, dp[N - 1][i]);
	}
	cout << result << "\n";
	return 0;
}