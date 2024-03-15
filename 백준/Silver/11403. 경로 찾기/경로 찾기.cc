#include <iostream>
#include <vector>
using namespace std;

int N; 
vector<int>v[101];
int arr[101][101] = {0};

void dfs(int n, bool visited[]) {
    for (int i = 0; i < v[n].size(); i++)
    {
        int num = v[n][i];
        if (!visited[num])
        {
            visited[num] = true;
            dfs(num, visited);
        }
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            int num; cin >> num;
            if (num)
            {
                v[i].push_back(j);
            }
        }
    }

    for (int i = 0; i < N; i++)
    {

        bool visited[101] = { false };
        dfs(i, visited);

        for (int k = 0; k < N; k++)
        {
            if (visited[k])cout << 1 << " ";
            else cout << 0 << " ";
        }
        cout << "\n";


    }
    

    return 0;
}