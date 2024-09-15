#include <iostream>
using namespace std; 
int arr[2][100001];
int dp[2][100001];
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T; cin >> T;
	while (T--)
	{
		int N; cin >> N;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < N; j++)
			{
				int num; cin >> num;
				arr[i][j] = num; 
			}
		}
		
		if (N == 1) {
			cout << max(arr[0][0], arr[1][0]) << "\n";
			continue;  
		}
		dp[1][0] = arr[1][0];
		dp[0][0] = arr[0][0];

		for (int j = 1; j < N; j++)
		{
			for (int i = 0; i < 2; i++)
			{
				if (i == 0) {
					dp[0][j] = max(dp[0][j - 1], dp[1][j - 1] + arr[0][j]);
				}
				else
				{
					dp[1][j] = max(dp[1][j - 1], dp[0][j - 1] + arr[1][j]);
				}
			}
		}
		cout << max(dp[0][N - 1], dp[1][N - 1]) << "\n";
	}


	return 0;
}