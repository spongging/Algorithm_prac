#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

int n, m;
int p, q;
vector<pair<int, int>>edge[100001];
vector<int>house;
const int INF = 1e9;
int dist[5001];

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
		for (int i = 0; i < edge[now].size(); i++)
		{
			int next = edge[now][i].first;
			int nextcost = edge[now][i].second;
			if (dist[next] > dist[now] + nextcost) {
				dist[next] = dist[now] + nextcost;
				pq.push({ -dist[next], next });
			}
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	int result = 0;
	int resultcost = INT_MAX;
	for (int i = 0; i <= 5000; i++) dist[i] = INF;
	for (int i = 0; i < m; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		edge[a].push_back({ b,c });
		edge[b].push_back({ a,c });
	}
	cin >> p >> q;
	for (int i = 0; i < p; i++)
	{
		int num; cin >> num;
		house.push_back(num);
	}
	for (int i = 0; i < q; i++)
	{
		int num; cin >> num;
		dijkstra(num);
		for (int j = 0; j < house.size() ; j++)
		{
			int tmp = house[j];
			if (dist[tmp] < resultcost) {
				result = tmp;
				resultcost = dist[tmp];
			}
		}
	}

	cout << result << "\n";

	return 0;
}
