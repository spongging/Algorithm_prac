#include<bits/stdc++.h>
using namespace std;
int dp[3][100001];
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int c;
	 

	cin >> c;
	while (c--) {
		int n, l1, l2, s1, s2;
		cin >> n >> l1 >> l2 >> s1 >> s2;
		vector<int> p1ps(n);
		vector<int> p1dr(n);
		vector<int> p2ps(n);
		vector<int> p2dr(n);
		dp[1][0] = l1;
		dp[2][0] = l2;
		for (int i = 0; i < n-1; i++) {
			cin >> p1ps[i];
		}
		for (int i = 0; i < n-1; i++) {
			cin >> p1dr[i];
		}
		for (int i = 0; i < n-1; i++) {
			cin >> p2ps[i];
		}
		for (int i = 0; i < n-1; i++) {
			cin >> p2dr[i];
		} 
		for (int i = 1; i <= n-1; i++) {
			dp[1][i] = min(dp[2][i - 1] + p2ps[i-1],dp[1][i-1]+p1dr[i-1]);//1한테패스해서 드리블 하냐 패스하냐
			dp[2][i] = min(dp[1][i - 1] + p1ps[i - 1], dp[2][i - 1] + p2dr[i - 1]);
		}
		
		int ans = 0;
		ans = min(dp[1][n - 1] + s1, dp[2][n - 1] + s2);
		cout << ans<<"\n";
	}
}