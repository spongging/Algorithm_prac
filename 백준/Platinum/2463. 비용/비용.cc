#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
const int MOD = 1000000000;
int N, M, x, y, cost;
int parent[100001], level[100001];
priority_queue<pair<int, pair<int, int>>>edge;

int find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = find(parent[x]);
}

void merge(int x, int y) {
	parent[y] = x;
	level[x] += level[y];
	level[y] = 1;
	return;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N >> M;
	ll total = 0; ll result = 0;
	for (int i = 0; i <= M; i++)
	{
		parent[i] = i;
		level[i] = 1;
	}
	for (int i = 0; i < M; i++)
	{
		cin >> x >> y >> cost;
		edge.push({ cost,{x,y} });
		total += cost;
	}
	for (int i = 0; i < M; i++)
	{
		pair<int, pair<int, int>>temp = edge.top();
		edge.pop();
		int tmp1 = find(temp.second.first);
		int tmp2 = find(temp.second.second);
		int curcost = temp.first;
		if (tmp1 != tmp2) {
			result += ((1L * level[tmp1] * level[tmp2] % MOD) * total) % MOD;
			result %= MOD;
			merge(tmp1, tmp2);
		}
		total -= curcost;
	}
	cout << result << "\n";
}

