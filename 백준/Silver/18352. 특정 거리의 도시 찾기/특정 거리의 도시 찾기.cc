#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<pair<int, int>>edge[1000000];
const int INF = 1e9; 
int N, M, K, X; 
int dist[300000]; 

void dijkstra(int start) {

	priority_queue<pair<int, int>>pq; 
	pq.push({ 0,start });
	dist[start] = 0;

	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int now = pq.top().second;
		pq.pop();
		
		if (dist[now] < cost) continue;
		for (int i = 0; i<edge[now].size(); i++) {
			int next = edge[now][i].first;
			int nextcost = edge[now][i].second;
			if (dist[next] > dist[now] + nextcost) {
				dist[next] = dist[now] + nextcost;
				pq.push({ -dist[next],next });
			}
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M >> K >> X;
	for (int i = 0; i < M; i++)
	{
		int a, b; cin >> a >> b;
		edge[a].push_back(make_pair(b, 1));
	}
	fill(dist, dist + 300000, INF); 
	dijkstra(X);
	bool TF = false;
	for (int i = 1; i <= N; i++)
	{
		if (dist[i] == K) {
			cout << i << "\n";
			TF = 1;
		}
	}
	if (!TF) cout << -1 << "\n";
	return 0;
}

