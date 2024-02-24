#include <iostream>
#include <vector>
using namespace std;

int N, M, K;
vector<int>v;
vector<vector<int>>party(51); 
int parent[51];

void init() {
	for (int i = 1; i < 51; i++) parent[i] = i;
}

int find(int x) {
	if (x == parent[x]) return x;
	return parent[x] = find(parent[x]);
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);
	parent[y] = x;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M >> K; 
	for (int i = 0; i < K; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}

	init();

	for (int i = 0; i < M; i++)
	{
		int p; cin >> p;
		int prev, num;

		for (int j = 0; j < p; j++) // merge same party
		{
			cin >> num;
			if (j >= 1) merge(prev, num);
			prev = num; 
		}

		party[i].push_back(num); 
	}

	
	
	for (auto& list : party) {
		bool flag = false;
		for (int i : list) {
			if (flag) break;
			for (auto& t : v) {
				if (find(i) == find(t)) {
					flag = true;
					break;
				}
			}
		}
		if (flag)M--;
	}

	cout << M << "\n";
	
	return 0;
}