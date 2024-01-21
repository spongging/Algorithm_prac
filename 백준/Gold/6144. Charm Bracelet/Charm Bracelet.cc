#include <iostream>
#include <vector>
using namespace std;

int dp[12881];  // 1차원 배열로 변경

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<pair<int, int>> v;
    v.push_back(make_pair(0, 0));

    int N, T;
    cin >> N >> T;

    for (int i = 0; i < N; i++) {
        int a, b;
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }

    for (int i = 1; i <= N; i++) {
        for (int j = T; j >= 1; j--) {  // 배열 초기화 부분에서 j를 감소하면서 초기화
            if (v[i].first <= j) {
                dp[j] = max(dp[j], dp[j - v[i].first] + v[i].second);
            }
        }
    }

    cout << dp[T] << "\n";

    return 0;
}
