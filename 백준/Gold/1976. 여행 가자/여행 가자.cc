#include <iostream>
#include <vector>
using namespace std;

int parent[201];
int N, M;
int arr[201][201] = {0};
vector<int>v;

int find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = find(parent[x]);
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);
	if (x > y) parent[x] = y;
	else parent[y] = x;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < 201; i++) parent[i] = i; 
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num;
			if (num == 1) merge(i, j);
		}
	}

	for (int i = 1; i <= M; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}
	int init = parent[v[0]];
	for (int i = 1; i < M; i++)
	{
		if (init != parent[v[i]]) {
			cout << "NO" << "\n";
			return 0;
		}
	}
	cout << "YES" << "\n";
    return 0;
}
