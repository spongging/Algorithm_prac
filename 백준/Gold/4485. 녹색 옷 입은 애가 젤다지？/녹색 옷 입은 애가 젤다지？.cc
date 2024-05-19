#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

const int INF = 1e9;
int N;
int arr[126][126];
int dist[126][126];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int cnt = 0;

int dijkstra(int start) {
	priority_queue<pair<int, pair<int, int>>>pq;
	pq.push({ -arr[0][0],{0,0} });
	dist[0][0] = arr[0][0];
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
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				int nextcost = arr[nx][ny];
				if (dist[nx][ny] > dist[x][y] + nextcost) {
					dist[nx][ny] = dist[x][y] + nextcost;
					pq.push({ -dist[nx][ny],{nx,ny} });
				}
			}
		}
	}
	return dist[N - 1][N - 1];
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1)
	{
		cin >> N;
		cnt++; 
		if (N == 0) exit(0);
		for (int i = 0; i < 126; ++i) {
			fill(dist[i], dist[i] + N, INF);
		}
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				int num; cin >> num;
				arr[i][j] = num;
			}
		}
		cout << "Problem" << " " << cnt << ": " << dijkstra(0) << "\n";
		
	}

	return 0;
}

