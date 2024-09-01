#include <iostream>
using namespace std;
int arr[501][501] = { 10000 }; 
int dp[501][501] = { 10000 }; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N; cin >> N; 
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < i + 1; j++)
		{
			int num; cin >> num;
			arr[i][j] = num; 
		}
	}
	dp[0][0] = arr[0][0];  
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < i + 1; j++)
		{
			if (j - 1 < 0) {
				dp[i][j] = dp[i - 1][j] + arr[i][j];
			}
			else if (arr[i - 1][j] == 10000) {
				dp[i][j] = dp[i - 1][j - 1] + arr[i][j]; 
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j]; 
			}
		}
	}
	int result = 0; 
	for (int i = 0; i < N; i++)
	{
		result = max(result, dp[N - 1][i]); 
	}
	cout << result << "\n"; 
	return 0;
}