#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

int n;
ll arr[1000001];
ll tree[1000001*4];

ll query(int node, int st, int ed, int k) {
    if (st == ed)return ed;
    int mid = (st + ed) / 2;
    if (tree[node * 2] >= k) return query(node * 2, st, mid, k);
    else return query(node * 2 + 1, mid + 1, ed, k-tree[node*2]);
}

void update(int node, int st, int ed, int idx, ll value) {
    if (idx<st || idx>ed) return;
    if (st == ed) {
        tree[node] = value;
        return;
    }
    int mid = (st + ed) / 2;
    update(node * 2, st, mid, idx, value);
    update(node * 2 + 1, mid + 1, ed, idx, value);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];

}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        ll a, b, c; cin >> a >> b;
        if (a == 1)
        {
            int k = query(1, 1, 1000001, b);
            cout << k << "\n";
            update(1, 1, 1000001, k, arr[k] - 1);
            arr[k]--;
        }
        else
        {
            cin >> c;
            update(1, 1, 1000001, b, arr[b] + c);
            arr[b] += c;
        }
    }

    return 0;
}
