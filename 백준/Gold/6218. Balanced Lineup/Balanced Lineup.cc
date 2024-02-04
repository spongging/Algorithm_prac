#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int N, Q, h = 1;
vector<int>maxTree;
vector<int>minTree;

void maxUpdate(int idx, int value) {
	idx += h;
	maxTree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		maxTree[idx] = max(maxTree[idx * 2], maxTree[idx * 2 + 1]);
	}
}

void minUpdate(int idx, int value) {
	idx += h;
	minTree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		minTree[idx] = min(minTree[idx * 2], minTree[idx * 2 + 1]);
	}
}

int maxQuery(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && nodeR <= R) return maxTree[node];
	if (nodeR<L || nodeL>R) return 0;
	int mid = (nodeL + nodeR) / 2;
	return max(maxQuery(L, R, node * 2, nodeL, mid), maxQuery(L, R, node * 2 + 1, mid + 1, nodeR));
}

int minQuery(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && nodeR <= R) return minTree[node];
	if (nodeR<L || nodeL>R) return INT_MAX;
	int mid = (nodeL + nodeR) / 2;
	return min(minQuery(L, R, node * 2, nodeL, mid), minQuery(L, R, node * 2 + 1, mid + 1, nodeR));
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> Q;
	while (N > h)h <<= 1;
	minTree.resize(h * 2);
	maxTree.resize(h * 2);
	fill(maxTree.begin(), maxTree.end(), 0);
	fill(minTree.begin(), minTree.end(), INT_MAX);

	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		maxUpdate(i, num);
		minUpdate(i, num);
	}

	for (int i = 0; i < Q; i++)
	{
		int a, b; cin >> a >> b;
		int tmp1 = maxQuery(a - 1, b - 1, 1, 0, h-2);
		int tmp2 = minQuery(a - 1, b - 1, 1, 0, h-2);
		cout << tmp1 - tmp2 << "\n";
	}

	return 0;
}
