#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
int arr[9];
int tmp[9];


void dfs(int idx, int num ) {
    if (num==M)
    {
        for (int i = 0; i < M; i++)
        {
            cout << tmp[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = idx; i < N; i++)
    {
        tmp[num] = arr[i];
        dfs(i + 1, num + 1);
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
        arr[i] = num;
    }
    sort(arr, arr + N); 
    dfs(0, 0);
    
    return 0;
}