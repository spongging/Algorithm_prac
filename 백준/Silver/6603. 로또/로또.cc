#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int k, num;
int arr[14];

void dfs(int idx, int level, vector<int> &v) {
    if (level == 6) {
        for (int i = 0; i < 6; i++)
        {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    for (int i = idx; i < k; i++)
    {
        arr[level] = v[i];
        dfs(i + 1, level + 1, v);
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (1)
    {
        cin >> k;
        vector<int>v;
        if (k == 0) break;
        for (int i = 0; i < k; i++)
        {
            cin >> num;
            v.push_back(num);
        }
        dfs(0, 0,v);
        cout << "\n";
    }
    
    return 0;
}