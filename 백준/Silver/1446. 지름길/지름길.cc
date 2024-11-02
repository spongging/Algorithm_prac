#include <iostream>
#include <vector>
using namespace std;
int dist[10001]; 
vector<pair<int, int>>v[10001];
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 

    int N, D; cin >> N >> D;
    for (int i = 0; i < N; i++)
    {
        int a, b, c; cin >> a >> b >> c;
        v[a].push_back({ b,c });
    }
    int now = 0; 
    for (int i = 0; i <= 10000; i++) dist[i] = i; 
    while (1)
    {
        if (now == D) {
            cout << dist[now] << "\n";
            break; 
        }
        for (int i = 0; i < v[now].size(); i++)
        {
            if (dist[v[now][i].first] > dist[now] + v[now][i].second)
            {
                int tmp = dist[now] + v[now][i].second;
                dist[v[now][i].first] = tmp;

                for (int j = v[now][i].first + 1; j <= D; j++)
                {
                    if (dist[j] >= tmp)
                    {
                        dist[j] = ++tmp;
                    }
                    else break; 
                }
            }
        }
        now++; 
    }
   
    return 0;
}
