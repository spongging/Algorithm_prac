#include <iostream>
using namespace std; 
int n, m;
int parent[500001];

int find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = find(parent[x]); 
}

bool func(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return 1;
	if (x < y) parent[y] = x;
	else parent[x] = y;
	return 0;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	cin >> n >> m;
	for (int i = 1; i <= n; i++) parent[i] = i;
	int cnt = 0;
	while (m--)
	{
		cnt++;
		int a, b; cin >> a >> b;
		if (func(a, b)) {
			cout << cnt << "\n";
			exit(0);
		}
	}
	cout << 0 << "\n";
	return 0;
}