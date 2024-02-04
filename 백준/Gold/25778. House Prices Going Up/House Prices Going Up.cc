#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

int N, T, h = 1;
vector<ll>tree;
ll nums[500001];

void update(int idx, ll value) {
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && nodeR <= R) return tree[node];
	if (nodeR<L || nodeL>R) return 0;
	int mid = (nodeL + nodeR) / 2;
	return query(L, R, node * 2, nodeL, mid) + query(L, R, node * 2 + 1, mid + 1, nodeR); 
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	while (N > h)h <<= 1;
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), 0);

	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num;
		nums[i] = num;
		update(i, num);
	}

	cin >> T;

	for (int i = 0; i < T; i++)
	{
		char a; int b, c; cin >> a >> b >> c;
		if (a == 'R') cout << query(b - 1, c - 1, 1, 0, h - 2) << "\n";
		else {
			ll value = nums[b - 1] + c;
			nums[b - 1] = value;
			update(b - 1, value);
		}
	}

	return 0;
}
