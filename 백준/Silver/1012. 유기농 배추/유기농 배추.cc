#include <iostream>
#include <cstring>
using namespace std; 

int arr[51][51];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };
bool visited[51][51];  
int m, n, k;

void dfs(int y, int x) {
	for (int i = 0; i < 4; i++)
	{
		int xx, yy;
		xx = x + dx[i], yy = y + dy[i]; 
		if (xx < 0 || yy < 0 || xx >= n || yy >= m)
		{
			continue;
		}
		else if (arr[yy][xx] == 1 && !visited[yy][xx])
		{
			visited[yy][xx] = true;
			dfs(yy, xx);
		}
		else continue;
	}
	return;
}

int main() {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);   
	int t; cin >> t; 
	while (t--) 
	{
		int cnt = 0;
		cin >> m >> n >> k; 
		for (int i = 0; i < k; i++)
		{
			int x, y; cin >> x >> y;
			arr[x][y] = 1;
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (arr[j][i] == 1 && !visited[j][i])
				{
					visited[j][i] = true;
					cnt++; 
					dfs(j, i); 
 				}
			}
		}
		cout << cnt << "\n";
		memset(visited, false, sizeof(visited));
		memset(arr, 0, sizeof(arr));
	}
	

	
	return 0;
}