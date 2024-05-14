#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, K;
const int INF = 1e9;
int dist[100001];

void dijkstra(int start) {
	priority_queue<pair<int, int>>pq;
	pq.push({ 0,start });
	dist[start] = 0;
	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int now = pq.top().second;
		pq.pop();

		for (int i = 0; i < 3; i++)
		{
			int next; int nextcost;
			if (i == 0) {
				next = now + 1;
				nextcost = cost + 1;
			}
			else if (i == 1) {
				next = now - 1;
				nextcost = cost + 1;
			}
			else
			{
				next = now * 2;
				nextcost = cost;
			}

			if (next < 0 || next>100000) continue;
			if (dist[next] == INF) {
				dist[next] = nextcost;
				pq.push({ -nextcost,next });
			}
			else if (dist[next] > nextcost) {
				dist[next] = nextcost;
				pq.push({ -nextcost,next });
			}

		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> K;
	for (int i = 0; i <= 100000; i++) dist[i] = INF;
	dijkstra(N);
	cout << dist[K] << "\n";

	return 0;
}

