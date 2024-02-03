#include <iostream> 
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;

vector<ll>tree; 
pair<ll, ll>nums[500001]; 
int n, h = 1;

void update(int idx) { // update tree node +=1
	idx += h;
	tree[idx] += 1;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) { 
	if (L <= nodeL && nodeR <= R) return tree[node];
	if (nodeL > R || nodeR < L) return 0;
	int mid = (nodeL + nodeR) / 2;
	return query(L, R, node * 2, nodeL, mid) + query(L, R, node * 2 + 1, mid + 1, nodeR);
} 

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n; ll sum = 0; 
	while (n > h)h <<= 1;
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), 0);

	for (int i = 0; i < n; i++)
	{
		ll num; cin >> num;
		nums[i] = make_pair(num, i); 
	}
	
	sort(nums, nums + n); // to starting small number

	for (int i = 0; i < n; i++) // start query
	{
		int idx = nums[i].second; 
		sum += query(idx + 1, n - 1, 1, 0, h - 2); //finding a index that bigger than idx 
		update(idx); // updating a tree
	}

	cout << sum << "\n";

	return 0;
}
