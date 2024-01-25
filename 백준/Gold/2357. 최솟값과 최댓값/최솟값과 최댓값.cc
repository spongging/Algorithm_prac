#include <iostream> 
#include <vector>
#include <climits>
using namespace std;

vector<int>minTree;
vector<int>maxTree;
int N, M, h = 1;

void update(int idx, int value) {
	idx += h;
	minTree[idx] = value;
	maxTree[idx] = value;
	while (idx > 1) {
		idx = idx / 2;
		minTree[idx] = min(minTree[idx * 2], minTree[idx * 2 + 1]);
		maxTree[idx] = max(maxTree[idx * 2], maxTree[idx * 2 + 1]);
	}
}

int minQuery(int L, int R, int node, int nodeL, int nodeR) { //find minimun
	if (L <= nodeL && R >= nodeR) return minTree[node];
	if (L > nodeR || R < nodeL) return INT_MAX;
	int mid = (nodeL + nodeR) / 2;
	return min(minQuery(L, R, node * 2, nodeL, mid), minQuery(L, R, node * 2 + 1, mid + 1, nodeR));
}

int maxQuery(int L, int R, int node, int nodeL, int nodeR) { //find maxinum
	if (L <= nodeL && R >= nodeR) return maxTree[node];
	if (L > nodeR || R < nodeL) return 0;
	int mid = (nodeL + nodeR) / 2;
	return max(maxQuery(L, R, node * 2, nodeL, mid), maxQuery(L, R, node * 2 + 1, mid + 1, nodeR));
}

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	cin >> N >> M;
	while (N > h) h <<= 1;

	minTree.resize(h * 2); maxTree.resize(h * 2); //resize a tree
	fill(minTree.begin(), minTree.end(), INT_MAX); //fill tree node
	fill(maxTree.begin(), maxTree.end(), 0); 

	for (int i = 0; i < N; i++) // updating a tree
	{
		int num; cin >> num;
		update(i, num);
	}

	for (int i = 0; i < M; i++) // start query
	{
		int L, R; cin >> L >> R;
		cout << minQuery(L, R, 1, 1, h) << " " << maxQuery(L, R, 1, 1, h) << "\n";
	}

	return 0;
}

