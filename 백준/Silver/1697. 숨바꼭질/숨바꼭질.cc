#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N, K;
bool visited[100001];
queue<pair<int, int>>q;
void bfs(int N) {
    q.push(make_pair(N, 0));
    visited[N] = true;
    if (N == K)
    {
        cout << 0;
        return;
    }
    while (!q.empty())
    {
        int n = q.front().first;
        int cnt = q.front().second;
        q.pop();
        if (n==K)
        {
            cout << cnt << "\n";
            return;
        }
        int a, b, c;
        a = n - 1; b = n + 1; c = 2 * n;
        if (a >= 0 && a < 100001 && visited[a] == false)
        {
            q.push(make_pair(a, cnt + 1));
            visited[a] = true;
        }
        if (b >= 0 && b < 100001 && visited[b] == false)
        {
            visited[b] = true;
            q.push(make_pair(b, cnt + 1));
        }
        if (c >= 0 && c < 100001 && visited[c] == false)
        {
            visited[c] = true;
            q.push(make_pair(c, cnt + 1));
        }
    }
    return;
}
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K; //input condition 
    bfs(N); //bfs

    return 0;
}
