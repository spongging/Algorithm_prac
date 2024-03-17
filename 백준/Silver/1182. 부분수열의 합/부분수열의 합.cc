#include <iostream>
using namespace std;

int arr[21];
int N, S, cnt = 0;

void dfs(int idx, int sum) {
    if (idx == N) return;
    if (sum +arr[idx] == S) cnt++;
    dfs(idx + 1, sum+arr[idx]);
    dfs(idx + 1, sum);
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> S;

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        arr[i] = num;
    }

    dfs(0, 0);

    cout << cnt << "\n";
    return 0;
}