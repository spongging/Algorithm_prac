#include <iostream>
#include <queue>
#include <climits>
using namespace std;
int M;
char arr[51][51];
int total_white = 0;
int mindis = INT_MAX;
int dx[3] = { 0,-1,1 }; // right, up, down
int dy[3] = { 1,0,0 };
int bfs(int x, int y, int cnt) {
    queue<pair<pair<int, int>, int>>q;
    bool visited[51][51] = { false };
    q.push({ {x,y},cnt });
    visited[x][y] = 1;
    while (!q.empty())
    {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int cnt = q.front().second;
        q.pop();
        if (y == M - 1) {
            return cnt;
        }
        for (int i = 0; i < 3; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 2 && ny >= 0 && ny < M)
            {
                if (!visited[nx][ny] && arr[nx][ny] != '#')
                {
                    visited[nx][ny] = 1;
                    q.push({ {nx,ny},cnt + 1 });
                }
            }
        }
    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> M;
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < M; j++)
        {
            char c; cin >> c;
            arr[i][j] = c; 
            if (c == '.') total_white++; 
        }
    }
    for (int i = 0; i < 2; i++)
    {
        if (arr[i][0] == '.') {
            mindis = min(mindis, bfs(i, 0, 1));
        }
    }
    cout << total_white - mindis << "\n";
    return 0;
}
