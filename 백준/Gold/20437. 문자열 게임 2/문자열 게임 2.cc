#include <iostream>	
#include <vector>
#include <climits>
using namespace std;
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int T; cin >> T;
	while (T--)
	{
		string s; cin >> s;
		int K; cin >> K;
		vector<int>v(26, 0);
		int minresult = INT_MAX;
		int maxresult = 0;
		for (int i = 0; i < s.length(); i++) v[s[i] - 'a']++;
		for (int i = 0; i < s.length(); i++)
		{	
			if (v[s[i] - 'a'] < K) continue;
			int cnt = 0;
			int cnt2 = 0;
			for (int j = i; j < s.length(); j++)
			{
				cnt++;
				if (s[i] == s[j]) {
					cnt2++;
					if (cnt2 != K) {
						continue;
					}
					minresult = min(minresult, cnt);
					maxresult = max(maxresult, cnt); 
					break;
				}
			}
		}
		if (minresult == INT_MAX) cout << -1 << "\n";
		else cout << minresult << " " << maxresult << "\n";
	}

	return 0;
}