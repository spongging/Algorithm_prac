#include <iostream>
#include <vector>
#include <climits>
using namespace std;
int N, M, W;
vector<pair<pair<int, int>, int>>edge;
bool bellman_ford() {
	int dist[2500] = { INT_MAX };
	dist[1] = 0;
	for (int i = 1; i < N; i++)
	{
		for (int j = 0;  j < edge.size();  j++)
		{
			int from = edge[j].first.first;
			int to = edge[j].first.second;
			int cost = edge[j].second;
			if (dist[from] == INT_MAX) continue;
			if (dist[to] > dist[from] + cost) dist[to] = dist[from] + cost;
		}
	}
	for (int j = 0; j < edge.size(); j++)
	{
		int from = edge[j].first.first;
		int to = edge[j].first.second;
		int cost = edge[j].second;
		if (dist[from] == INT_MAX) continue;
		if (dist[to] > dist[from] + cost)return 1;
	}
	return 0;
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int TC; cin >> TC;
	while (TC--)
	{
		cin >> N >> M >> W;
		for (int i = 0; i < M; i++)
		{
			int S, E, T; cin >> S >> E >> T;
			edge.push_back({ {S,E},T });
			edge.push_back({ {E,S}, T });
		}
		for (int i = 0; i < W; i++)
		{
			int S, E, T; cin >> S >> E >> T;
			edge.push_back({ {S,E},-T });
		}
		if (bellman_ford())cout << "YES" << "\n";
		else cout << "NO" << "\n";
		edge.clear(); 
	}

	return 0;
}