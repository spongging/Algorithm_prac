#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<vector<pair<int, string>>> v(300);
	vector<pair<int,string>>pv;
	int p, m; cin >> p >> m;
	for (int i = 0; i < p; i++)
	{
		int l; string n; cin >> l >> n;
		pv.push_back({ l,n }); 
	}
	v[0].push_back({pv[0].first, pv[0].second});

	int idx = 0;
	for (int i = 1; i < p; i++)
	{
		for (int j = 0; j <= idx; j++)
		{
			if (v[j][0].first + 10 >= pv[i].first && v[j][0].first - 10 <= pv[i].first) {
				if (v[j].size() < m) {
					v[j].push_back({ pv[i].first,pv[i].second }); 
					break; 
				}
			}
			if (j == idx) {
				idx++;  
				v[idx].push_back({ pv[i].first,pv[i].second });
				break; 
			}
		}
	}

	for (int i = 0; i <= idx; ++i) { 
		sort(v[i].begin(), v[i].end(), [](const pair<int, string>& a, const pair<int, string>& b) { 
			return a.second < b.second; 
			});
	}

	for (int i = 0; i <= idx; i++)
	{
		if (v[i].size() == m) {
			cout << "Started!" << "\n";
			for (int j = 0; j < m; j++)
			{
				cout << v[i][j].first << " " << v[i][j].second << "\n";
			}
		}
		else
		{
			cout << "Waiting!" << "\n";
			for (int j = 0; j < v[i].size(); j++)
			{
				cout << v[i][j].first << " " << v[i][j].second << "\n";
			}
		}
	}

	return 0;
}