#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, K;
vector<pair<int, pair<int, int>>>edge;
vector<pair<int, int>>newedge[1001];
int parent[1001];
int result1 = 0;
int result2 = 0;
bool visited[1001];

int find(int x) {
	if (x == parent[x]) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

bool merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return false;
	if (x > y) parent[x] = y;
	else parent[y] = x;
	return true;
}

int dfs(int idx, int tmp) {
	visited[idx] = 1;
	int maxcost = tmp;
	for (int i = 0; i < newedge[idx].size(); i++)
	{
		int next = newedge[idx][i].first;
		int cost = newedge[idx][i].second;
		if (!visited[newedge[idx][i].first]) {
			maxcost = max(maxcost, dfs(newedge[idx][i].first, tmp + cost));
		}
	}

	return maxcost; 

}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> K;
	for (int i = 0; i < 1001; i++) parent[i] = i;
	for (int i = 0; i < K; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		edge.push_back({ c,{a,b} });
	}
	sort(edge.begin(), edge.end());
	for (int i = 0; i < edge.size(); i++)
	{
		if (merge(edge[i].second.first, edge[i].second.second)) {
			result1 += edge[i].first;
			newedge[edge[i].second.first].push_back({ edge[i].second.second, edge[i].first });
			newedge[edge[i].second.second].push_back({ edge[i].second.first, edge[i].first });
		}
	}
	for (int i = 0; i < N; i++) 
	{
		fill(visited, visited + 1001, false);
		result2 = max(result2, dfs(i, 0));
	}
	cout << result1 << "\n";
	cout << result2 << "\n";

	return 0;
}

