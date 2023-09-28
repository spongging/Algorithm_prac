#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int>path;
bool visited[9] = { 0, };

void dfs(int num, int cnt) {
	if (cnt == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << path[i] << " ";
		}
		cout << endl;
		return;
	}
	for (int i = num; i <= N; i++)
	{
		path.push_back(i);
		visited[i] = true;
		dfs(i, cnt + 1);
		path.pop_back();
		visited[i] = false;
	}
	return;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	dfs(1,0);

	return 0;
}