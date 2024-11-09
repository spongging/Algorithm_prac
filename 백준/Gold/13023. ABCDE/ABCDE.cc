#include <iostream>
#include <vector>
using namespace std;
vector<int>v[2001];
bool visited[2001];
int N, M;
bool flag = 0;
void dfs(int num, int depth) {
    if (flag) return;
    if (depth == 4)
    {
        flag = 1;
        return;
    }
    visited[num] = 1;
    for (int i = 0; i < v[num].size(); i++)
    {
        int tmp = v[num][i]; 
        if (!visited[tmp]) {
            visited[tmp] = 1;
            dfs(tmp, depth + 1);
            visited[tmp] = 0;
        }
    }
    return; 
}
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
   
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int from, to; cin >> from >> to;
        v[from].push_back(to);    
        v[to].push_back(from);
    }
    for (int i = 0; i < N; i++)
    {
        fill(visited, visited + 2001, false);
        dfs(i, 0);
        if (flag) {
            cout << 1 << "\n";
            return 0;
        }
    }
    cout << 0 << "\n"; 
    return 0;
}
