#include <iostream>
#include <vector>
using namespace std; 
typedef long long ll;   
vector<int>nums; vector<ll>tree;
int N, M, K; int h = 1;

void update(int idx, ll value) { // update the each node
	idx += h;
	tree[idx] = value;
	while(idx > 1) {
		idx /= 2;
		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
}

ll query(int L, int R, int node, int nodeL, int nodeR) { // get section sum 
	
	if (L > nodeR || R < nodeL) return 0;
	if (L <= nodeL && R >= nodeR) return tree[node];
	int mid = (nodeL + nodeR) / 2;
	return query(L, R, node * 2, nodeL, mid) + query(L, R, node * 2 + 1, mid + 1, nodeR);
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N >> M >> K;  
	
	while (N > h) h <<= 1; // use shift for finding h
	nums.resize(N + 1); // resize nums array and tree size
	tree.resize(2 * h);
	fill(tree.begin(), tree.end(), 0); // init all node of tree to zero

	for (int i = 0; i < N; i++) //updating a tree
	{
		ll num; cin >> num; 
		update(i, num);
	}
	for (int i = N + 1; i < N + M + K + 1; i++) // starting a query
	{
		int a, b; ll c; cin >> a >> b >> c; 
		if (a == 1) update(b - 1, c);
		if (a == 2) cout << query(b, c , 1, 1, h) << "\n";
	}

	return 0;
}
