#include <iostream>
using namespace std;

int R, C, K;
string s;
char map[6][6];
int visited[6][6];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

//2,0
int dfs(int y, int x) {
	int result = 0;
	if (y == 0 && x == C - 1) // reach the target
	{
		if (visited[y][x] == K)
		{
			return 1;
		}
		return 0;
	}

	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < C && ny>=0 && ny < R && !visited[ny][nx] && map[ny][nx] != 'T')
		{
			visited[ny][nx] = visited[y][x] + 1;
			result += dfs(ny, nx);
			visited[ny][nx] = 0;
		}
	}
	return result;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> R >> C >> K;
	for (int i = 0; i < R; i++) // input string
	{
		cin >> s;
		for (int j = 0; j < C; j++)
		{
			map[i][j] = s[j];
		}
	}
	visited[R - 1][0] = 1; // starting point
	cout << dfs(R - 1, 0) << "\n";
	return 0;

}