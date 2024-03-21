#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int>v;
int arr[9];
bool visited[9] = { false };

void dfs(int level) {

    if (level == M) {
        for (int j = 0; j < M; j++)
        {
            cout << arr[j] << " ";
        }
        cout << "\n";
        return;
    }

    int tmp = 0;
    for (int i = 0; i < N; i++)
    {
        if (!visited[i] && v[i] != tmp)
        {
            arr[level] = v[i];
            tmp = arr[level];
            visited[i] = 1;
            dfs(level + 1);
            visited[i] = 0;
        }
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }

    sort(v.begin(), v.end());
    dfs(0);
    

    return 0;
}