#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 1001 
using namespace std;

int N, M, V; 
bool visited[MAX]; 
vector<int>graph[10001]; 
queue<int>q;

void dfs(int n) {
	if (!visited[n])
	{
		visited[n] = true;
		cout << n << " "; 
	}
	for (int i = 0; i < graph[n].size(); i++)
	{
		int tmp = graph[n][i];
		if (!visited[tmp])
		{
			visited[tmp] = true;
			cout << tmp << " ";
			dfs(tmp);
		}
	}
	return;
}

void reset() {

	for (int i = 1; i <= N; i++)
	{
		visited[i] = false;
	}
	return;
}

void bfs(int n) {

	q.push(n);
	visited[n] = true; cout << n << " ";
	while (!q.empty())
	{
		int x = q.front();
		q.pop();
		for (int i = 0; i < graph[x].size(); i++)
		{
			int tmp = graph[x][i];
			if (!visited[tmp])
			{ 
				visited[tmp] = true;
				q.push(tmp); cout << tmp << " ";
			}
		}
	}

	return;
}

int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 

	cin >> N >> M >> V;
	for (int i = 0; i < M; i++)
	{
		int e1, e2; 
		cin >> e1 >> e2;
		graph[e1].push_back(e2);
		graph[e2].push_back(e1);
	}
	for (int i = 1; i <= N; i++)
	{
		sort(graph[i].begin(), graph[i].end()); 
	}
	dfs(V); cout << "\n";
	reset(); 
	bfs(V);

	return 0;
}