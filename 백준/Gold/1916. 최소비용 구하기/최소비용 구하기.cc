#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;
vector<pair<int, int>>edge[100001];
int N, M;
int st, ed;
int dist[1001];
void dijkstra(int start) {
    priority_queue<pair<int, int>>pq;
    dist[start] = 0;
    pq.push({ 0,start });
    while (!pq.empty())
    {
        int cost = -pq.top().first;
        int node = pq.top().second;
        pq.pop();
        if (dist[node] < cost) continue;
        for (int i = 0; i < edge[node].size(); i++)
        {
            int nxt_node = edge[node][i].first;
            int nxt_cost = edge[node][i].second;
            if (dist[nxt_node] > dist[node] + nxt_cost)
            {
                dist[nxt_node] = dist[node] + nxt_cost;
                pq.push({ -nxt_cost,nxt_node }); 
            }
        }
    }
}
int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> N >> M;
    for (int i = 0; i <= 1000; i++) dist[i] = INT_MAX;
    for (int i = 0; i < M; i++)
    {
        int from, to, cost; cin >> from >> to >> cost;
        edge[from].push_back({ to,cost });
    }
    cin >> st >> ed;
    dijkstra(st);
    cout << dist[ed] << "\n";

    return 0;
}
