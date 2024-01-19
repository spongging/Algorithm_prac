#include <iostream>
#include <vector>
using namespace std;
int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	int T; cin >> T;
	for (int i = 0; i < T; i++)
	{
		int dp[10001] = { 0 };
		int coins[21];
		dp[0] = 1;

		int N; cin >> N;
		for (int z = 0; z < N; z++) //input coins
		{
			int num; cin >> num;
			coins[z] = num;
		}
		int target; cin >> target;
		//dp
		for (int j = 0; j < N; j++)
		{
			int init = coins[j];
			for (int p = init; p <= target; p++)
			{
				if (init <= p)
				{
					dp[p] = dp[p] + dp[p - init];
				}
			}
		}
		cout << dp[target] << "\n";
	}
	return 0;
}