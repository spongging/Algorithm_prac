#include <iostream>
#include <queue>
using namespace std;

int M, N;
int arr[101][101];
int st1, st2, stdir, ed1, ed2, eddir;
int d1[5] = { 0,0,0,1,-1 }; // 동 서 남 북
int d2[5] = {0, 1,-1,0,0 };
bool visited[101][101][5] = { 0 };

bool TF(int x, int y, int dir, int i) {
	int nx = x + d1[dir] * i;
	int ny = y + d2[dir] * i;
	if (nx<1 || ny<1 || nx>M || ny>N) return 0;

	nx = x;
	ny = y;
	for (int j = 0; j < i; j++)
	{
		nx += d1[dir];
		ny += d2[dir];
		if (arr[nx][ny] == 1) return false;
	}
	return 1;
}

int changeDir(int dir, char c) {
	if (c == 'L') {
		if (dir == 1) return 4;
		else if (dir == 2) return 3;
		else if (dir == 3) return 1;
		else return 2;
	}
	else
	{
		if (dir == 1) return 3;
		else if (dir == 2) return 4;
		else if (dir == 3) return 2;
		else return 1;
	}
}

int bfs() {
	queue<pair<pair<int, int>, pair<int,int>>>q;
	q.push({ { st1,st2 }, {stdir,0} });
	visited[st1][st2][stdir] = 1;  
	while (!q.empty())
	{
		int sst1 = q.front().first.first;
		int sst2 = q.front().first.second;
		int sstdir = q.front().second.first;
		int cnt = q.front().second.second;
		q.pop();

		if (sst1 == ed1 && sst2 == ed2 && eddir == sstdir) {
			return cnt; 
		}

		for (int i = 1; i <= 3; i++)
		{
			if (TF(sst1, sst2, sstdir, i)) {
				int nnst1 = sst1 + d1[sstdir] * i;
				int nnst2 = sst2 + d2[sstdir] * i;
				if (!visited[nnst1][nnst2][sstdir]) {
					visited[nnst1][nnst2][sstdir] = 1;
					q.push({ {nnst1,nnst2}, {sstdir,cnt + 1} });
				}
			}
		}
		int nd1 = changeDir(sstdir, 'L');
		if (!visited[sst1][sst2][nd1]) {
			visited[sst1][sst2][nd1] = 1;
			q.push({ {sst1,sst2},{nd1,cnt + 1} });
		}
		int nd2 = changeDir(sstdir, 'R');
		if (!visited[sst1][sst2][nd2]) {
			visited[sst1][sst2][nd2] = 1;
			q.push({ {sst1,sst2},{nd2,cnt + 1} });
		}
	}
	return -1; 
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> M >> N;
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num; 
			arr[i][j] = num; 
		}
	}
	cin >> st1 >> st2 >> stdir;
	cin >> ed1 >> ed2 >> eddir; 
	cout << bfs() << "\n"; 

	return 0;
}