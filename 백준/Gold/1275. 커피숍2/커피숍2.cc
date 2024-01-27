#include <iostream> 
#include <vector>
using namespace std;
typedef long long ll;

vector<ll>tree;
int N, Q, h = 1;

void update(int idx, ll value) {
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // sum the child trees
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && R >= nodeR) return tree[node];
	if (L > nodeR || R < nodeL) return 0;
	int mid = (nodeL + nodeR) / 2;
	return query(L, R, node * 2, nodeL, mid) + query(L, R, node * 2 + 1, mid + 1, nodeR);
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N >> Q;
	while (N > h)h <<= 1;
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), 0);

	for (int i = 0; i < N; i++) // updating a tree 
	{
		ll num; cin >> num;
		update(i, num);
	}
	
	for (int i = 0; i < Q; i++)
	{
		int x, y, a; ll b; cin >> x >> y >> a >> b;
		if (x > y) {							// comparing x, y 
			int tmp; tmp = x; x = y; y = tmp; 
		}
		cout << query(x, y, 1, 1, h) << "\n"; // finding sum of section
		update(a - 1, b); // updating a tree
	}

	return 0;
}
