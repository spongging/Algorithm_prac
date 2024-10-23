#include <iostream>
#include <vector>
#include <queue>    
using namespace std;
vector<int>cow_dis;
vector<vector<int>>v(10000); 
int K, N, M;
int cnt[1001] = { 0 };
void bfs(int idx) {
    queue<int>q; 
    q.push(idx); 
    bool visited[1001] = { false };
    visited[idx] = 1; 
    cnt[idx]++;
    while (!q.empty())
    {
        int tmp = q.front();
        q.pop();
        for (int i = 0; i < v[tmp].size(); i++)
        {
            if (!visited[v[tmp][i]])
            {
                q.push(v[tmp][i]);
                cnt[v[tmp][i]]++;
                visited[v[tmp][i]] = 1;
            }
        }
    }
}

int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 

    int result = 0; 
    cin >> K >> N >> M;
    for (int i = 0; i < K; i++)
    {
        int num; cin >> num; 
        cow_dis.push_back(num);
    }
    for (int i = 0; i < M; i++)
    {
        int a, b; cin >> a >> b;
        v[a].push_back(b);
    }
    for (int i = 0; i < K; i++)
    {
        bfs(cow_dis[i]); 
    }
    for (int i = 1; i <= N; i++)
    {
        if (cnt[i] == K) result++;
    }
    cout << result << "\n";
    return 0;
}
