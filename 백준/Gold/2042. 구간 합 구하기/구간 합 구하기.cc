#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;

ll N, M, K;
vector<ll>v, tree;

ll sum(int i) {
    int idx = i;
    ll ans = 0;
    while (idx > 0) {
        ans += tree[idx];
        idx -= idx & -idx;
    }
    return ans;
}

void update(int i, ll diff) {
    int idx = i;
    while (idx <= tree.size()) {
        tree[idx] += diff;
        idx += idx & -idx;
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> K;
    v.resize(N + 5);
    tree.resize(N + 5);

    for (int i = 1; i <= N; i++)
    {
        cin >> v[i];
        update(i, v[i]);
    }

    M += K;

    while (M--)
    {
        ll a, b, c;
        cin >> a >> b >> c;

        if (a == 1) {
            ll diff = c - v[b];
            v[b] = c;
            update(b, diff);
        }
        else {
            cout << sum(c) - sum(b - 1) << "\n";
        }
    }

    return 0;
}