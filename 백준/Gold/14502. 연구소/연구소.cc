#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int arr[8][8];
int copyarr[8][8];
int copybfsarr[8][8];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int result = 0;

void bfs() {

	queue<pair<int, int>>virous;
	copy(&copyarr[0][0], &copyarr[0][0] + 8 * 8, &copybfsarr[0][0]);

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{	
			if (copybfsarr[i][j] == 2) virous.push(make_pair(i, j));
		}
	}

	while (!virous.empty())
	{
		int y = virous.front().first;
		int x = virous.front().second;
		virous.pop();
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i]; 
			int ny = y + dy[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N || copybfsarr[ny][nx] == 1 || copybfsarr[ny][nx] == 2) continue;
			copybfsarr[ny][nx] = 2; 
			virous.push(make_pair(ny, nx));
		}
	}
	int tmp = 0;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (copybfsarr[i][j] == 0) tmp += 1;
		}
	}
	result = max(result, tmp);
}

void wall(int cnt) {

	if (cnt == 3) {
		bfs();
		return;
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (copyarr[i][j] == 0) {
				copyarr[i][j] = 1;
				wall(cnt + 1);
				copyarr[i][j] = 0;
			}
		}
	}

}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int num; cin >> num;
			arr[i][j] = num;
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{

			if (arr[i][j] == 0) {
				copy(&arr[0][0], &arr[0][0] + 8 * 8, &copyarr[0][0]);
				copyarr[i][j] = 1;
				wall(1);
				copyarr[i][j] = 0;
			}
		}
	}

	cout << result << "\n";

	return 0;
}