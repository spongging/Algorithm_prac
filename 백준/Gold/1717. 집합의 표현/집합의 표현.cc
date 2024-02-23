#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int parent[1000001];
int ran[1000001]; // saving level of tree

void init() {
	for (int i = 1; i < 1000001; i++) {
		parent[i] = i;
		ran[i] = 1; 
	}
}

int find(int x) {
	if (parent[x] == x) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

void merge(int x, int y) { // some people called union
	x = find(x);
	y = find(y); 
	if (x == y) return; // same parent
	if (ran[x] > ran[y]) swap(x, y); // comparing level of those tree
	parent[y] = x; // making same parent
	if (ran[x] == ran[y]) ran[y]++; 
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	
	init();

	for (int i = 0; i < M; i++)
	{
		int a, b, c; cin >> a >> b >> c; 
		if (a == 0) merge(b, c);
		else
		{
			if (find(b) == find(c)) cout << "YES" << "\n";
			else cout << "NO" << "\n";
		}
	}

	return 0;
}