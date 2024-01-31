#include <iostream> 
#include <vector>
using namespace std;

int N, K, h = 1;
vector<int>tree;

int change(int value1, int value2) { 
	int tmp = value1 * value2;
	if (tmp > 0) return 1;
	else if (tmp < 0) return -1;
	else return 0;
}

void update(int idx, int value) { // updating a tree
	idx += h;
	tree[idx] = value;
	while (idx > 1) {
		idx /= 2;
		tree[idx] = change(tree[idx * 2], tree[idx * 2 + 1]);
	}
}

int query(int L, int R, int node, int nodeL, int nodeR) {
	if (L <= nodeL && nodeR <= R) return tree[node];
	if (L > nodeR || R < nodeL) return 1;
	int mid = (nodeL + nodeR) / 2;
	return change(query(L, R, node * 2, nodeL, mid), query(L, R, node * 2 + 1, mid + 1, nodeR));
}


int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	while (cin >> N >> K) {

		while (N > h)h <<= 1;
		tree.resize(2 * h);
		fill(tree.begin(), tree.end(), 1);
		vector<char>arr;

		for (int i = 0; i < N; i++)
		{
			int num; cin >> num;
			if (num > 0) num = 1; // change the num through case
			else if (num < 0) num = -1;
			else num = 0;
			update(i, num);
		}

		for (int i = 0; i < K; i++)
		{
			char a; int b, c; cin >> a >> b >> c;
			if (a == 'C') update(b - 1, c);
			if (a == 'P') {
				int tmp = query(b, c, 1, 1, h);
				if (tmp > 0) arr.push_back('+');
				else if (tmp < 0) arr.push_back('-');
				else arr.push_back('0');
			}
		}
		for (char word : arr) cout << word;
		cout << "\n";
	}
	return 0;
}
