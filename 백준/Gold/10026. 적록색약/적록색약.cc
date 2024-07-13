#include <iostream>
#include <queue>
using namespace std;

char arr[101][101];
char arr2[101][101];
bool visited[101][101] = { 0 };
bool visited2[101][101] = { 0 };
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int N;
int result = 0;
int result2 = 0;

void bfs(int x, int y) {
	queue<pair<int, int>>q;
	q.push({ x,y });
	visited[x][y] = 1;
	while (!q.empty())
	{
		int xx = q.front().first;
		int yy = q.front().second;
		q.pop();
		char init = arr[xx][yy];
		for (int i = 0; i < 4; i++)
		{
			int nx = xx + dx[i];
			int ny = yy + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N)
			{
				if (arr[nx][ny] == init && !visited[nx][ny]) {
					q.push({ nx,ny });
					visited[nx][ny] = 1; 
				}
			}
		}
	}
}
void bfs2(int x, int y) {
	queue<pair<int, int>>q;
	q.push({ x,y });
	visited2[x][y] = 1;
	while (!q.empty())
	{
		int xx = q.front().first;
		int yy = q.front().second;
		q.pop();
		char init = arr2[xx][yy];
		for (int i = 0; i < 4; i++)
		{
			int nx = xx + dx[i];
			int ny = yy + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N)
			{
				if (arr2[nx][ny] == init && !visited2[nx][ny]) {
					q.push({ nx,ny });
					visited2[nx][ny] = 1;
				}
			}
		}
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		string s; cin >> s;
		for (int j = 0; j < N; j++)
		{
			arr[i][j] = s[j]; 
			if (s[j] == 'G') {
				arr2[i][j] = 'R';
				continue;
			}
			arr2[i][j] = s[j];
			
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (!visited[i][j]) {
				bfs(i, j);
				result++; 
			}
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (!visited2[i][j]) {
				bfs2(i, j);
				result2++; 
			}
		}
	}
	cout << result << " " << result2 << "\n"; 
	return 0;
}