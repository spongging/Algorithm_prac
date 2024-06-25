#include <iostream>
#include <queue>
using namespace std;
int M, N, H;
int arr[101][101][101];
bool visited[101][101][101];
queue<pair<pair<int, int>, pair<int, int>>> q;
int dm[6] = {1,-1,0,0,0,0};
int dn[6] = {0,0,1,-1,0,0};
int dh[6] = { 0,0,0,0,1,-1 };
int result = 0;
void bfs() {
	while (!q.empty())
	{
		int m = q.front().first.second;
		int n = q.front().first.first;
		int h = q.front().second.first;
		int cnt = q.front().second.second;
		result = max(result, cnt);
		q.pop();
		for (int i = 0; i < 6; i++)
		{
			int nm = m + dm[i];
			int nn = n + dn[i];
			int nh = h + dh[i];
			if (nm >= 0 && nm < M && nn >= 0 && nn < N && nh >= 0 && nh < H && !visited[nh][nn][nm]) {
				if (arr[nh][nn][nm] == 0) {
					arr[nh][nn][nm] = 1;
					visited[nh][nn][nm] = 1;
					q.push({ {nn,nm},{nh,cnt + 1} });
				}
			}
			
		}
	}
}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> M >> N >> H;
	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < N; j++)
		{
			for (int k = 0; k < M; k++)
			{
				int num; cin >> num;
				arr[i][j][k] = num;
				if (num == 1) {
					q.push({ {j,k},{i,0} });
				}
			}
		}
	}
	bfs();
	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < N; j++)
		{
			for (int k = 0; k < M; k++)
			{
				if (arr[i][j][k] == 0) {
					cout << -1 << "\n";
					exit(0);
				}
			}
		}
	}
	cout << result << "\n";
	return 0;
}
