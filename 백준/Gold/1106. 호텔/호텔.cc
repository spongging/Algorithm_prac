#include <iostream>
#include <vector>
using namespace std;
int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	vector<pair<int, int>>v;
	int dp[100001] = { 0 }; //1000*10

	int C, N; cin >> C >> N;
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		v.push_back(make_pair(a, b));
	}
	dp[0] = 0;
	///
	for (int i = 0; i < N; i++)
	{
		int init = v[i].first;
		for (int j = init; j <= 100000; j++)
		{
			dp[j] = max(dp[j], dp[j - init] + v[i].second);
		}
	}
	for (int i = 1; i < 100001; i++)
	{
		if (dp[i] >= C)
		{
			cout << i << "\n";
			return 0;
		}
	}
	return 0;
}