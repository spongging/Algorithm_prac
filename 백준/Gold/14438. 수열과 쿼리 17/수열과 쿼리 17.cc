#include <iostream> 
#include <vector>
#include <climits>
using namespace std;

int N, M, h = 1; 
vector<int>tree;

void update(int idx, int value) { // updating a tree 
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = min(tree[idx * 2], tree[idx * 2 + 1]);
	}
}

int query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && R >= nodeR) return tree[node];
	if (L > nodeR || R < nodeL) return INT_MAX;
	int mid = (nodeL + nodeR) / 2;
	return min(query(L, R, node * 2, nodeL, mid), query(L, R, node * 2 + 1, mid + 1, nodeR));
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N;

	while (N > h) h <<= 1;
	tree.resize(h * 2);
	fill(tree.begin(), tree.end(), INT_MAX); // filling all node into INT_MAX

	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		update(i, num);
	}

	cin >> M;

	for (int i = 0; i < M; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		if (a == 1) update(b - 1, c);
		if (a == 2) cout << query(b, c, 1, 1, h) << "\n";
	}

	return 0;
}

