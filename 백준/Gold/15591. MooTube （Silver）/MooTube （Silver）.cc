#include <iostream>
#include <queue>
#include <vector>
#include <climits>
using namespace std;
vector<pair<int, int>>edge[5001];
int N, Q;
int bfs(int start, int limit) {
    queue<pair<int, int>>q;
    bool visited[5001] = {false};
    int cnt = 0;
    q.push({ start, INT_MAX });
    visited[start] = 1;
    while (!q.empty())
    {
        int point = q.front().first;
        int cost = q.front().second;
        q.pop();
        for (int i = 0; i < edge[point].size(); i++)
        {
            int nextPoint = edge[point][i].first; 
            int nextCost = edge[point][i].second;
            if (visited[nextPoint]) continue;
            if (cost < nextCost)
            {
                nextCost = cost;
            }
            if (nextCost >= limit)
            {
                cnt++;
            }
            visited[nextPoint] = 1; 
            q.push({ nextPoint,nextCost });
        }
    }
    return cnt;
}
int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> Q;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b, cost; cin >> a >> b >> cost;
        edge[a].push_back({ b,cost });
        edge[b].push_back({ a,cost });
    }
    while (Q--)
    {
        int K, V;  
        cin >> K >> V;
        cout << bfs(V, K) << "\n";
    }
    return 0;
}
