#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> v;
vector<bool>visited;
int n, m; 
int cnt = 0;
void dfs(int idx) {
	if (visited[idx])
	{
		return;
	}
	visited[idx] = true;
	for (int i = 0; i < v[idx].size(); i++)
	{
			int num = v[idx][i];
			if (!visited[num])
			{
				dfs(num);
				cnt++;
			}
	}
	return;
}
int main() {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	
	cin >> n;
	cin >> m;
	v.resize(n + 1); visited.resize(n + 1, false);
	for (int i = 0; i < m; i++)
	{
		int a, b;

		cin >> a >> b;
		v[a].push_back(b); 
		v[b].push_back(a); 
	}
	dfs(1);
	cout << cnt << "\n";

	return 0;
}