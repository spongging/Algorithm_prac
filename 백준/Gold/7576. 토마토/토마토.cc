#include <iostream>
#include <queue>
using namespace std;

int M, N;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue<pair<int, int>>q; //queue has (x,y)
int arr[1001][1001];

void bfs() {

    while (!q.empty())
    {
        int x = q.front().first; int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int xx = x + dx[i]; int yy = y + dy[i];
            if (xx >= 0 && xx < M && yy >= 0 && yy < N && arr[yy][xx] == 0)
            {
                arr[yy][xx] = arr[y][x] + 1;
                q.push(make_pair(xx, yy));
            }
        }
    }
}

int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> M >> N;

    for (int i = 0; i < N; i++) 
    {
        for (int j = 0; j < M; j++)
        {
            int num; cin >> num;
            if (num == 1)
            {
                q.push(make_pair(j, i)); //define that x coordinate is j, y coordinate is i
            }
            arr[i][j] = num;
        }
    }

    bfs();
    
    int result = 0;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (arr[i][j] == 0)
            {
                cout << -1 << "\n";
                return 0;
            }
            if (result < arr[i][j])
            {
                result = arr[i][j];
            }
        }

    }
    cout << result - 1 << "\n";
    return 0;
}
