#include <iostream>
#include <queue>
#include <map>
using namespace std;

int N, M; 
int dx[6] = { 1,2,3,4,5,6 };
bool TF[101] = { 0 };
bool visited[101] = { 0 }; 
map<int, int>m;

int bfs() {
	queue<pair<int, int>>q;
	q.push({ 1,0 });
	visited[1] = 1; 
	while (!q.empty())
	{
		int x = q.front().first;
		int cnt = q.front().second;
		q.pop(); 
		for (int i = 0; i < 6; i++)
		{
			int nx = x + dx[i];
			if (nx == 100) {
				return cnt + 1;
			}
			if (TF[nx]) {
				nx = m[nx];
				if (!visited[nx]) {
					q.push({ nx,cnt + 1 });
					visited[nx] = 1;
				}
				continue;
			}
			if (nx < 100) {
				if (!visited[nx]) {
					q.push({ nx,cnt + 1 });
					visited[nx] = 1;
				}
			}
		}
	}
	return 0;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N + M; i++)
	{
		int a, b; cin >> a >> b;
		TF[a] = 1;
		m[a] = b; 
	}
	cout << bfs() << "\n";
	return 0;
}