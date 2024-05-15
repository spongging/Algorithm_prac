#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<pair<int, int>>edge[100000];
const int INF = 1e9;
int N, A, B;
int dist[101];

void dijkstra(int start) {

	priority_queue<pair<int, int>>pq;
	dist[start] = 0;
	pq.push({ 0,start });
	
	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int now = pq.top().second;
		pq.pop();
		if (dist[now] < cost) continue;
		for (int i = 0; i < edge[now].size(); i++)
		{
			int nextcost = edge[now][i].second;
			int next = edge[now][i].first; 
			if (dist[next] > dist[now] + nextcost) {
				dist[next] = dist[now] + nextcost;
				pq.push({ -dist[next],next});
			}
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> A >> B;
	for (int i = 0; i <= 100; i++) dist[i] = INF;
	for (int i = 0; i < N; i++)
	{
		int k; cin >> k;
		if (k == 1) {
			int a; cin >> a;
			edge[i + 1].push_back({ a, 0 });
			continue;
		}
		for (int j = 0; j < k; j++)
		{
			int a; cin >> a;
			if (j == 0) {
				edge[i+1].push_back({ a,0 });
			}
			else edge[i + 1].push_back({ a,1 });
		}
	}

	dijkstra(A);
	if (dist[B] == INF) {
		cout << -1 << "\n";
		exit(0);
	}
	cout << dist[B] << "\n";

	return 0;
}

