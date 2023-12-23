#include <iostream>
using namespace std;
char arr[601][601];
bool visited[601][601] = { false };
int cnt = 0;
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };
int N, M;
void dfs(int y, int x) {
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (!visited[ny][nx] && nx >= 0 && ny >= 0 && nx < M && ny < N) {
            visited[ny][nx] = true;
            if (arr[ny][nx]=='P')
            {
                cnt++;
            }
            if (arr[ny][nx]=='X')
            {
                return;
            }
            dfs(ny, nx);
        }
    }
}
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    
    
    cin >> N >> M;
    int firstx, firsty;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            char w; cin >> w;
            if (w == 'I')
            {
                firstx = j; firsty = i;
            }
            if (w == 'X')
            {
                visited[i][j] = true;
            }
            arr[i][j] = w;
        }
    }
    visited[firsty][firstx] = true;
    dfs(firsty, firstx);
    if (cnt==0)
    {
        cout << "TT" << "\n";
    }
    else
    {
        cout << cnt << "\n";
    }
    return 0;
}
