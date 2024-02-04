#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M;
int arr[1001][1001];
int visited[1001][1001] = { 0 };
int d_x[4] = { 0,0,-1,1 };
int d_y[4] = { -1,1,0,0 };
queue<pair<int, int>>q; 

void bfs(int x, int y) {

	q.push(make_pair(x, y));
	visited[x][y] = 1;

	while (!q.empty()) {

		int firstx = q.front().first;
		int firsty = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++)
		{
			int dx = firstx + d_x[i];
			int dy = firsty + d_y[i]; 
			if (dx >= 0 && dx < N && dy >= 0 && dy < M)
			{
				if (visited[dx][dy] == 0 && arr[dx][dy] != 0)
				{
					visited[dx][dy] = visited[firstx][firsty] + 1;
					q.push(make_pair(dx, dy));
				}
			}
		}
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M; 
	int initx, inity;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int num; cin >> num;
			if (num == 2)
			{
				initx = i;
				inity = j;
			}
			arr[i][j] = num; 
		}
	}

	bfs(initx, inity);

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (arr[i][j] == 0) cout << 0 << " ";
			else cout << visited[i][j] - 1 << " ";
		}
		cout << "\n";
	}

	return 0;
}
