#include <iostream>
using namespace std; 
typedef long long ll; 
ll m, n, result = 0;  
ll arr[301][301] = { 0 };
ll presum[301][301];  

ll func(ll a, ll b) {
	ll cnt = 0;
	for (int i = a; i <= m; i++)
	{
		for (int j = b; j <= n; j++)
		{
			ll sum = presum[i][j] - presum[i][b - 1] - presum[a - 1][j] + presum[a - 1][b - 1]; 
			if (sum == 10) cnt++;
			if (sum >= 10) break; 
		}
	}
	return cnt;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	cin >> m >> n;
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			ll num; cin >> num;
			arr[i][j] = num;
		}
	}
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			presum[i][j] = presum[i][j - 1] + presum[i - 1][j] + arr[i][j] - presum[i - 1][j - 1];
		}
	}

	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			ll tmp = func(i, j);
			result += tmp;
		}
	}
	cout << result << "\n"; 
	return 0;
}