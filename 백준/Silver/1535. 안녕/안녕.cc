#include <iostream>
using namespace std;
int dp[21][101]; int L[21]; int J[21];
int main(void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 
	
	int N; cin >> N; 
	L[0] = 0, J[0] = 0;
	for (int i = 1; i <= N; i++)
	{
		int a; cin >> a;
		L[i] = a; //체력
	}
	for (int i = 1; i <= N; i++)
	{
		int a; cin >> a;
		J[i] = a; //기쁨
	}
	//dp 초기화
	for (int i = 0; i <= N; i++)
	{
		dp[i][0] = 0;
	}
	for (int i = 0; i <= 101; i++)
	{
		dp[0][i] = 0;
	}
	//dp 시작
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= 100; j++)
		{
			if (L[i] > j)
			{
				dp[i][j] = dp[i - 1][j];
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - L[i]] + J[i]);
			}
		}
	}
	cout << dp[N][99] << "\n";
	return 0;
}