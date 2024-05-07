#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N;
vector<int>v[100001];
int arr[100001][1];
bool visited[100001] = { false };
queue<int>q;

void bfs(int x) {

	visited[x] = 1;
	q.push(x);
	while (!q.empty())
	{
		int xx = q.front();
		q.pop();
		for (int i = 0; i < v[xx].size(); i++)
		{
			int tmp = v[xx][i];
			if (!visited[tmp]) {
				arr[tmp][0] = xx;
				visited[tmp] = 1;
				q.push(tmp);
			}
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;
	for (int i = 0; i < N-1; i++)
	{
		int a, b; cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	bfs(1);
	for (int i = 2; i <= N; i++)
	{
		cout << arr[i][0] << "\n";
	}

	return 0;
}
