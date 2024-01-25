#include <iostream> 
#include <vector>
#include <climits>
using namespace std;

vector<int>tree;
int N, M, h = 1;

void update(int idx, int value) {
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx = idx / 2;
		tree[idx] = min(tree[idx * 2], tree[idx * 2 + 1]);
	}
}

int query(int L, int R, int node, int nodeL, int nodeR) { //find minimun
	if (L <= nodeL && R >= nodeR) return tree[node];
	if (L > nodeR || R < nodeL) return INT_MAX;
	int mid = (nodeL + nodeR) / 2;
	return min(query(L, R, node * 2, nodeL, mid), query(L, R, node * 2 + 1, mid + 1, nodeR));
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N >> M;
	while (N > h) h <<= 1;
	tree.resize(h * 2); //resize a tree
	fill(tree.begin(), tree.end(), INT_MAX); //fill tree node

	for (int i = 0; i < N; i++) // updating a tree
	{
		int num; cin >> num;
		update(i, num);
	}

	for (int i = 0; i < M; i++) // start query
	{
		int L, R; cin >> L >> R;
		cout << query(L, R, 1, 1, h) << "\n";
	}

	return 0;
}

