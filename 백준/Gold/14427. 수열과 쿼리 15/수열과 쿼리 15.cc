#include <iostream> 
#include <vector>
#include <climits>
using namespace std;

vector<int>tree;
vector<pair<int, int>>nums; // define that (idx, value)
int N, M, h = 1;

int comp(int idx1, int idx2) { // comparing value and return that index
	if (nums[idx1].second <= nums[idx2].second) return idx1;
	else return idx2;
}

void update(int idx, int idx2) {
	idx += h;
	tree[idx] = idx2;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = comp(tree[idx * 2], tree[idx * 2 + 1]);
	}
}

int query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && R >= nodeR) return tree[node];
	if (L > nodeR || R < nodeL) return 0;
	int mid = (nodeL + nodeR) / 2;
	return comp(query(L, R, node * 2, nodeL, mid), query(L, R, node * 2 + 1, mid + 1, nodeR));
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N;

	while (N > h)h <<= 1;
	nums.resize(N + 1);
	tree.resize(h * 2);
	nums[0] = make_pair(0, INT_MAX); // [0] = INT_MAX
	fill(tree.begin(), tree.end(), 0); // filling a tree node into idx 0

	for (int i = 0; i < N; i++) // updating a tree
	{
		int num; cin >> num;
		nums[i + 1] = make_pair(i + 1, num);
		update(i, i + 1);
	}
	
	cin >> M; 
	for (int i = 0; i < M; i++) //starting a query
	{
		int a, b, c; cin >> a;
		if (a == 1) {
			cin >> b >> c;
			nums[b].second = c;
			update(b - 1, b);
		}
		if (a == 2) {
			cout << tree[1] << "\n";
		}
	}

	return 0;
}
