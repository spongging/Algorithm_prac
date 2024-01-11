#include <iostream>
#include <vector>
using namespace std;
int main(void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 
	
	int T, N, M;
	cin >> T;
	for (int z = 0; z < T; z++)
	{
		cin >> N;
		int dp[10001] = { 0 };
		vector<int>v; 
		for (int i = 0; i < N; i++)
		{
			int num; cin >> num;
			v.push_back(num); 
		}
		cin >> M;
		////
		dp[0] = 1;
		for (int i = 0; i < N; i++)
		{
			int init = v[i]; 
			for (int j = init; j <= M; j++)
			{
				dp[j] = dp[j] + dp[j - init];
			}
		}
		cout << dp[M] << "\n";
	}
	return 0;
}