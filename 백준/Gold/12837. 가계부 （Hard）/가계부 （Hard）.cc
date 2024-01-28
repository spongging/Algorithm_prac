#include <iostream> 
#include <vector>
using namespace std;
typedef long long ll;

int N, Q, h = 1;
vector<ll>tree;
vector<ll>nums;

void update(int idx, ll value) { // Updating a tree
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) { // Finding a result
	if (L <= nodeL && nodeR <= R) return tree[node];
	if (L > nodeR || nodeL > R) return 0;
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
	nums.resize(N + 1);
	fill(tree.begin(), tree.end(), 0);
	fill(nums.begin(), nums.end(), 0);

	for (int i = 0; i < Q; i++) // starting a query
	{
		int a, p; ll x; cin >> a >> p >> x; 
		if (a == 1) {
			nums[p] += x; // Adding a nums array
			update(p - 1, nums[p]);
		}
		if (a == 2) cout << query(p, x, 1, 1, h) << "\n";
	}

	return 0;
}
