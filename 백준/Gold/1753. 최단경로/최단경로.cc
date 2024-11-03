#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;
int N, M; 
vector<pair<int, int>>v[50001]; 
int dist[50001];
void dijkstra(int start) {
    priority_queue<pair<int, int>>pq;
    dist[start] = 0;
    pq.push({ 0,start });
    while (!pq.empty())
    {
        int cost = -pq.top().first;
        int dis = pq.top().second;
        pq.pop();
        if (dist[dis] < cost) continue;
        for (int i = 0; i < v[dis].size(); i++)
        {
            if (dist[v[dis][i].first] > cost + v[dis][i].second)
            {
                dist[v[dis][i].first] = cost + v[dis][i].second;
                pq.push({ -(cost + v[dis][i].second), v[dis][i].first });
            }
        }
    }

}
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    cin >> N >> M; 
    for (int i = 0; i <= N; i++) dist[i] = INT_MAX;
    int start; cin >> start; 
    for (int i = 0; i < M; i++)
    {
        int from, to, cost; cin >> from >> to >> cost; 
        v[from].push_back({ to,cost }); 
    }
    dijkstra(start);
    for (int i = 1; i <= N; i++)
    {
        if (dist[i] == INT_MAX) cout << "INF" << "\n";
        else cout << dist[i] << "\n";
    }
    return 0;
}
