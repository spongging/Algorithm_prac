#include <iostream>
#include <vector>
using namespace std;

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	while (1)
	{
		int n; double m; cin >> n >> m;
		if (n == 0 && m == 0.00)
		{
			break;
		}
		int mm = (int)(100 * m + 0.5);
		vector<pair<int, int>>v;
		int dp[10001] = { 0 };
		for (int z = 0; z < n; z++)
		{
			int num1; double num2; cin >> num1 >> num2;
			int num22 = (int)(num2 * 100 + 0.5);
			v.push_back(make_pair(num1, num22));
		}
		/////
		for (int i = 0; i < n ; i++)
		{
			for (int j = v[i].second; j <= mm; j++) 
			{
				dp[j] = max(dp[j], dp[j - v[i].second] + v[i].first); 
			}
		}
		cout << dp[mm] << "\n"; 
	}
	return 0;
}