#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int V, E;
vector<pair<int, pair<int, int>>>v;
int parent[10001] = { 0 };

int find(int x) {
	if (parent[x] == x) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);
	parent[y] = x;
}


bool issame(int x, int y) {
	if (find(x) != find(y)) return false;
	return true;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> V >> E;
	int result = 0;
	for (int i = 1; i <= 10000; i++) parent[i] = i; //init
	for (int i = 0; i < E; i++)
	{
		int st, ed, val; cin >> st >> ed >> val;
		v.push_back(make_pair(val, make_pair(st, ed)));
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++)
	{
		int st = v[i].second.first;
		int ed = v[i].second.second;
		int val = v[i].first;
		if (issame(st, ed)) continue;
		merge(st, ed);
		result += val;

	}
	
	cout << result << "\n";

	return 0;
	
}
