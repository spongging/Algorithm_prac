#include <iostream>
#include <vector>
#include <climits>
#include <queue>
#include <map>
using namespace std;

int N, M, result;
vector<int>v[101];
queue<int>q;
int rs[101][101];
int minSum = INT_MAX; 

void bfs(int start) {

	q.push(start);
	bool visited[101] = { false };
	visited[start] = true;
	while (!q.empty())
	{
		int tmp = q.front(); //1
		q.pop();
		for (int i = 0; i < v[tmp].size(); i++)
		{
			int idx = v[tmp][i]; //3
			if (!visited[idx]) {
				visited[idx] = true;
				q.push(idx);
				rs[idx][start] = rs[tmp][start] + 1;
				rs[start][idx] = rs[start][tmp] + 1;
			}
		}
	}

}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < M; i++)
	{
		int a, b; cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			rs[i][j] = 0;
		}
	}

	for (int i = 1; i <= N; i++) {
		bfs(i);
	}

	for (int i = 1; i <= N; i++)
	{
		int sum = 0;
		for (int j = 1; j <= N; j++)
		{
			sum += rs[i][j];
		}
		if (sum < minSum) {
			result = i;
			minSum = sum;
		}
	}

	cout << result << "\n";

	return 0;
}