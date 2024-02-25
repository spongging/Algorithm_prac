#include <iostream>
#include <set>
using namespace std;

int parent[1001];
int N, M, u, v;
int cnt = 0;
set<int>s;

void init() {
	for (int i = 1; i < 1001; i++) parent[i] = i;
}

int find(int x) {
	if (x == parent[x]) return x;
	return parent[x] = find(parent[x]);
}

void merge(int x, int y) {
	x = find(x);
	y = find(y); 
	if (x == y) return;
	parent[y] = x;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	init();
	for (int i = 0; i < M; i++)
	{
		cin >> u >> v;
		merge(u, v);
	}

	for (int i = 1; i <= N; i++)
	{
		s.insert(find(parent[i]));
	}

	cout << s.size() << "\n";

	return 0;
}