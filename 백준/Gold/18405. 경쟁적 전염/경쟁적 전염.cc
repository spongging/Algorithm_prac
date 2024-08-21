#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int arr[201][201] = { 0 };
int N, K, S, X, Y;
queue<pair<int, pair<int, pair<int, int>>>>q;
vector<pair<int, pair<int, int>>>v; 
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 }; 
bool visited[201][201] = { 0 }; 
void bfs() {
	while (!q.empty())
	{
		int num = q.front().first;
		int cnt = q.front().second.first;
		int xx = q.front().second.second.first;
		int yy = q.front().second.second.second;
		visited[xx][yy] = 1;  
		q.pop(); 
		if (cnt > S) return;
		if (cnt == S)continue;
		for (int i = 0; i < 4; i++)
		{
			int nx = xx + dx[i];
			int ny = yy + dy[i]; 
			if (!visited[nx][ny] && nx >= 1 && nx <= N && ny >= 1 && ny <= N)
			{
				visited[nx][ny] = 1;
				arr[nx][ny] = num;  
				q.push({ num,{cnt + 1,{nx,ny}} });
			}
		}
	}
}
void init() {
	for (int i = 0; i < v.size(); i++)
	{
		q.push({ v[i].first,{0,{v[i].second.first,v[i].second.second}} });
	}
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> K;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num;
			arr[i][j] = num;
			if(num!=0) v.push_back({ num,{i,j} }); 
		}
	}
	cin >> S >> X >> Y;
	sort(v.begin(), v.end()); 
	init(); 
	bfs();  
	cout << arr[X][Y] << "\n";
	return 0;
}