#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int da[4] = { 0,-1,0,1 };
int db[4] = { 1,0,-1,0 }; // r,u,l,d

int N, M, result = INT_MAX;
int office[9][9];
vector<pair<int, int>>cctv_dir;


// 0 0 1
void cctv_check(int a, int b, int i) {

	i %= 4; // preventing overflow and searching dir of cctv

	while (1)
	{
		int na = a + da[i];
		int nb = b + db[i];
		a = na; b = nb; 
		if (office[na][nb] == 0 && office[na][nb]!=6
			&& na >= 0 && na < N && nb >= 0 && nb < M) {
			office[na][nb] = '#';
		}
		if (na < 0 || na >= N || nb < 0 || nb >= M) return;
		if (office[na][nb] == 6) return; // meet wall
		if (office[na][nb] != 0) continue; // ignore another cctv
	}
}

int check() { // checking 사각지대
	int cnt = 0;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (office[i][j] == 0) {
				cnt++;
			}
		}
	}
	return cnt;
}

void dfs(int idx) {

	if (idx == cctv_dir.size()) {
		int tmp = check();
		result = min(result, tmp);
		return;
	}

	int a = cctv_dir[idx].first; 
	int b = cctv_dir[idx].second;
	int tmparr[9][9];

	for (int k = 0; k < N; k++) // to saving previous status of office
	{
		for (int l = 0; l < M; l++)
		{
			tmparr[k][l] = office[k][l];
		}
	}
	 
	for (int i = 0; i < 4; i++) // i is direcion of watching cctv
	{

		for (int k = 0; k < N; k++) // to saving previous status of office
		{
			for (int l = 0; l < M; l++)
			{
				tmparr[k][l] = office[k][l];
			}
		}


		if (office[a][b] == 1) {
			cctv_check(a, b, i);
		}
		else if (office[a][b] == 2) {
			cctv_check(a, b, i);
			cctv_check(a, b, i + 2);
		}
		else if (office[a][b] == 3) {
			cctv_check(a, b, i);
			cctv_check(a, b, i + 1);
		}
		else if (office[a][b] == 4) {
			cctv_check(a, b, i);
			cctv_check(a, b, i + 1);
			cctv_check(a, b, i + 2);
		}
		else if (office[a][b] == 5) {
			cctv_check(a, b, i);
			cctv_check(a, b, i + 1);
			cctv_check(a, b, i + 2);
			cctv_check(a, b, i + 3);
		}
		else return; // error!

		dfs(idx + 1);

		for (int k = 0; k < N; k++) // to saving previous status of office
		{
			for (int l = 0; l < M; l++)
			{
				office[k][l] = tmparr[k][l];
			}
		}
	}
	

}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int num; cin >> num;
			office[i][j] = num;
			if (num >= 1 && num <= 5) {
				cctv_dir.push_back(make_pair(i, j)); 
			}
		}
	}


	dfs(0);
	cout << result << "\n";

	return 0;
}