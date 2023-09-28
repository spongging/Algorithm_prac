#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int>path;

void dfs(int num, vector<bool>&visited) {
	
	if (M == path.size())
	{
		for ( int i = 0; i < M; i++)
		{
			cout << path[i] << " ";
		}
		cout << endl;
		return;
	}

	for ( int i = num;  i <=N;  i++)
	{
		if (visited[i]!=true)
		{
			path.push_back(i);
			visited[i] = true;
			dfs(i + 1,visited);
			path.pop_back();
			visited[i] = false;
		}
	}
	return;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	vector<bool>visited(N + 1, false);
	dfs(1, visited);

	return 0;
}