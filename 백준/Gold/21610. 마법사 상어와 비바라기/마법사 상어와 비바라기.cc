#include <iostream>
#include <vector>
#include<cstring>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	bool cloud[51][51] = { false };
	int arr[51][51] = { 0 };
	vector<pair<int, int>>clouddir;
	vector<pair<int, int>>v;
	int dx[8] = { 0,-1,-1,-1,0,1,1,1 };
	int dy[8] = { -1,-1,0,1,1,1,0,-1 };
	int N, M; cin >> N >> M;

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num;
			arr[i][j] = num;
		}
	}

	clouddir.push_back(make_pair(N, 1)); 
	clouddir.push_back(make_pair(N, 2));
	clouddir.push_back(make_pair(N - 1, 1));
	clouddir.push_back(make_pair(N - 1, 2));
	cloud[N][1] = 1; 
	cloud[N][2] = 1;
	cloud[N - 1][1] = 1;
	cloud[N - 1][2] = 1;

	for (int i = 0; i < M; i++)
	{
		int a, b; cin >> a >> b;
		v.push_back(make_pair(a, b)); 
	}

	for (int i = 0; i < M; i++) //본게임 시작
	{
		int dir = v[i].first; 
		int cnt = v[i].second;
		int size = clouddir.size();
		memset(cloud, false, sizeof(cloud));

		for (int k = 0; k < size; k++)   // 구름 이동
		{ 

			int x = clouddir[k].first; 
			int y = clouddir[k].second; 

			for (int j = 0; j < cnt; j++) 
			{
				x += dx[dir-1]; 
				y += dy[dir-1]; 
				if (x == 0) x = N; 
				if (x > N) x = 1; 
				if (y == 0) y = N; 
				if (y > N) y = 1; 
			} 
			clouddir[k].first = x;
			clouddir[k].second = y;
			cloud[x][y] = 1;
		}

		for (int k = 0; k < clouddir.size(); k++) // 물 추가
		{
			arr[clouddir[k].first][clouddir[k].second]++;
		}

	

		for (int k = 0; k < clouddir.size(); k++) //버그 씀
		{
			int x = clouddir[k].first; 
			int y = clouddir[k].second; 
			if (x + dx[1] > 0 && x + dx[1] <= N && y + dy[1] > 0 && y + dy[1] <= N && arr[x + dx[1]][y + dy[1]] != 0) {
				arr[x][y]++;
			}
			if (x + dx[3] > 0 && x + dx[3] <= N && y + dy[3] > 0 && y + dy[3] <= N && arr[x + dx[3]][y + dy[3]] != 0) {
				arr[x][y]++;
			}
			if (x + dx[5] > 0 && x + dx[5] <= N && y + dy[5] > 0 && y + dy[5] <= N && arr[x + dx[5]][y + dy[5]] != 0) {
				arr[x][y]++;
			}
			if (x + dx[7] > 0 && x + dx[7] <= N && y + dy[7] > 0 && y + dy[7] <= N && arr[x + dx[7]][y + dy[7]] != 0) {
				arr[x][y]++;
			}
		}
	
		clouddir.clear();
		for (int k = 1; k <= N; k++) // 새로운구르 ㅁㅅㅇ성
		{
			for (int p = 1; p <= N; p++)
			{
				if (cloud[k][p]) continue;
				if (arr[k][p] < 2) continue;
				arr[k][p] -= 2;
				clouddir.push_back(make_pair(k, p));
			}
		}
		
		memset(cloud, false, sizeof(cloud));
		for (int k = 0; k < clouddir.size(); k++)
		{
			cloud[clouddir[k].first][clouddir[k].second] = 1;
		}

	
	}

	int answer = 0;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			answer += arr[i][j];
		}
	}
	cout << answer << "\n";
	
	return 0;
}
