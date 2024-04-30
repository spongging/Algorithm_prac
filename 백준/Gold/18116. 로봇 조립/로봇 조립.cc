#include <iostream>
#include <vector>
using namespace std;

int N;
int parent[1000001];
int cnt[1000001];

int find(int x) {
	if (parent[x] == x) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x >= y) {
		parent[x] = y;
		cnt[y] += cnt[x];
		cnt[x] = 0;
	}
	else{
		parent[y] = x;
		cnt[x] += cnt[y];
		cnt[y] = 0;
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N; 
	for (int i = 0; i < 1000001; i++) parent[i] = i;
	for (int i = 0; i < 1000001; i++) cnt[i] = 1;
	while (N--)
	{
		char c; int x, y;
		cin >> c;
		if (c == 'I') {
			cin >> x >> y; 
			if(find(x)!=find(y)) merge(x, y); 
		}
		else
		{
			cin >> x;
			cout << cnt[find(x)] << "\n";
		}
	}
	
	return 0;
}