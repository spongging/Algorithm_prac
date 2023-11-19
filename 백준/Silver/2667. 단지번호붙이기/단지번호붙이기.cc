#include <iostream>  
#include <vector>  
#include <algorithm> 
using namespace std;  
int N;
int arr[26][26];  
bool visited[26][26]; 
int dy[4] = { -1,1,0,0 }; 
int dx[4] = { 0,0,1,-1 }; 
vector<int>result;
int cnt = 0;
int cnt2 = 0;
void bfs(int x, int y) {
	visited[x][y] = true;
	cnt++;
	for (int i = 0; i < 4; i++) {
		int ddx = x + dx[i];
		int ddy = y + dy[i];
		if (ddx >= 0 && ddx < N && ddy >= 0 && ddy < N && arr[ddx][ddy] == 1 && !visited[ddx][ddy]) {
			visited[ddx][ddy] = true;
			bfs(ddx, ddy);
		}
	}
}

int main(void) {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		string cup; cin >> cup; 
		for ( int j = 0; j < N; j++)
		{
			if (cup[j] == '1') {
				arr[i][j] = 1;
			}
			else {
				arr[i][j] = 0;
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (arr[i][j] == 1 && !visited[i][j])
			{
				bfs(i, j);
				cnt2++;
				result.push_back(cnt);
				cnt = 0;
			}
		}
	}
	sort(result.begin(), result.end());
	cout << cnt2 << "\n";
	for (int i = 0; i < result.size(); i++)
	{
		cout << result[i] << "\n";
	}
	return 0;
}