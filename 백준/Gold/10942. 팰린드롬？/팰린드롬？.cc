#include <iostream>
using namespace std; 

int dp[2001][2001]; 
int num[2001]; int N, M; 
int s, e; 

int main() {

	ios_base::sync_with_stdio(false);  
	cin.tie(NULL);  
	cout.tie(NULL); 
	
	cin >> N;
	for (int i = 1; i <= N; i++) 
	{
		dp[i][i] = 1;
	}
	for (int i = 1; i <= N; i++)
	{
		int number; cin >> number;
		num[i] = number;
	}
	for (int i = 1; i < N; i++)
	{
		if (num[i] == num[i + 1]) dp[i][i + 1] = 1;
	}
	for (int i = N - 2 ; i >= 1; i--)
	{
		for (int j = i+2; j <= N; j++)
		{
			if (num[i] == num[j] && dp[i+1][j - 1] == 1) dp[i][j] = 1; 
		}
	}
	cin >> M;
	for (int m = 0; m < M; m++)
	{
		cin >> s >> e;  
		cout << dp[s][e] << "\n";  
	}

	return 0;
}