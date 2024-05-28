#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, M;
vector<pair<int, pair<int, int>>>edge;
int parent[10001];
int result = 0;

int find(int x) {
	if (x == parent[x]) return x;
	parent[x] = find(parent[x]);
	return parent[x];
}

bool merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return 1;
	if (x > y) parent[y] = x;
	else parent[x] = y;
	return 0;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i <= 10000; i++) parent[i] = i;
	for (int i = 0; i < M; i++)
	{
		int a, b, c, d; cin >> a >> b >> c >> d;
		if (d == 0) {
			result += c;
			edge.push_back({ c, make_pair(a, b) });
		}
		else
		{
			merge(a, b); 
		}
	}
	sort(edge.begin(), edge.end(), greater<pair<int, pair<int, int>>>());
	for (int i = 0; i < edge.size(); i++)
	{
		int TF = merge(edge[i].second.first, edge[i].second.second);
		if (!TF) result -= edge[i].first;
	}
	cout << result << "\n";
	
	return 0;
}

