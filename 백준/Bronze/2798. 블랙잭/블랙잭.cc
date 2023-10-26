#include <iostream>
#include <vector>
using namespace std;
vector<int>num; vector<int>num2;
vector<int>path;
void dfs(int idx) {
	if (path.size()==3)
	{
		int cnt = 0;
		for (int j = 0; j < 3; j++)
		{
			cnt += path[j];
		}
		num2.push_back(cnt);
		return;
	}
	for (int i = idx; i < num.size(); i++)
	{
		path.push_back(num[i]); 
		dfs(i + 1);
		path.pop_back();
	}
	
	return;
}

int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 
	
	int n, m; cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		int nn; cin >> nn;
		num.push_back(nn);
	}
	dfs(0);
	int max = 0;
	for (int i = 0; i < num2.size(); i++)
	{
		
		if (max<num2[i] && num2[i]<=m)
		{
			max = num2[i];
		}
	}
	cout << max << "\n";
	return 0;
}