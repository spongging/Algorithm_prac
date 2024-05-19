#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int N, M;
int dist[101][101];
int arr[101][101];
const int INF = 1e9;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int dijkstra(int start) {
	priority_queue<pair<int, pair<int, int>>>pq;
	pq.push({ 0,{0,0} });
	dist[0][0] = 0;
	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int x = pq.top().second.first;
		int y = pq.top().second.second;
		pq.pop();
		if (dist[x][y] < cost) continue;
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				int nextcost = arr[nx][ny];
				if (dist[nx][ny] > nextcost + dist[x][y]) {
					dist[nx][ny] = nextcost + dist[x][y];
					pq.push({ -dist[nx][ny],{nx,ny} });
				}
			}
		}
	}
	return dist[M-1][N - 1];
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> M;
	for (int i = 0; i < 101; ++i) {
		fill(dist[i], dist[i] + 101, INF);
	}
	for (int i = 0; i < M; i++)
	{
		string s; cin >> s;
		for (int j = 0; j < N; j++)
		{
			int num = s[j] - '0';
			arr[i][j] = num; 
		}
	}
	cout << dijkstra(0) << "\n";

	return 0;
}

