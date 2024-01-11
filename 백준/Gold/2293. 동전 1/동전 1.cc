#include <iostream>
#include <vector>
using namespace std;
int dp[10001] = { 0 };
vector<int>v;
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k; cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}
	dp[0] = 1;
	for (int i = 0; i < n; i++)
	{
		int init = v[i]; 
		for (int j = init; j <= k; j++)
		{
			dp[j] = dp[j] + dp[j - init];
		}
	}
	cout << dp[k] << "\n";
	return 0;
}