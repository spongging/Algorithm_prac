#include <iostream> 
#include <vector>
using namespace std;
typedef long long ll;

vector<ll>tree;
int N, M, K, h = 1;

void update(int idx, ll value) { // updating a segment tree
	idx += h;
	tree[idx] = value % 1000000007;
	while(idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] * tree[idx * 2 + 1] % 1000000007;
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) { //finding a section of multiple
	if (L <= nodeL && R >= nodeR) return tree[node];
	if (L > nodeR || R < nodeL) return 1;
	int mid = (nodeL + nodeR) / 2;
	return query(L, R, node * 2, nodeL, mid) * query(L, R, node * 2 + 1, mid + 1, nodeR) % 1000000007;
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N >> M >> K;
	
	while (N > h)h <<= 1; 
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), 1); // fill all tree of node into 1

	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num; 
		update(i, num);
	}

	for (int i = N; i <= N + M + K - 1; i++)
	{
		int a, b, c; cin >> a >> b >> c; 
		if (a == 1) update(b - 1, c); // if a is 1, updating a tree
		if (a == 2) cout << query(b, c, 1, 1, h) << "\n"; // if a is 2, finding result
	}

	return 0;
}

