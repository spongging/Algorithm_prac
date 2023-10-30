#include <iostream>
#include <vector>
using namespace std;
int dp[301];
int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL);  
	cout.tie(NULL) ; 
	
	int n; cin >> n;
	vector<int>scores{ 0, };
	dp[0] = 0;
	for (int i = 1; i <= n; i++)
	{
		int score; cin >> score;
		scores.push_back(score);
	}
	dp[0] = 0; dp[1] = scores[1]; dp[2] = scores[1] + scores[2];

	if (n>=3)
	{
		dp[3] = max(scores[1], scores[2]) + scores[3];
	}

	for (int i = 4; i <= n; i++)
	{
		dp[i] = max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i];
	}
	cout << dp[n] << "\n";
	return 0;
}