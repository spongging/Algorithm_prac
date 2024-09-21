#include <iostream>
#include <vector>
using namespace std; 
int N, M; 
char arr[10][10];
int result = 0;
vector<pair<int, int>>pv; 
bool visited[10][10] = {0};
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
string bases = "YOKOHAMA";
void dfs(int a, int b, int level) {
	if (level == 8) {
		result++;
		return;
	}
	visited[a][b] = 1; 
	for (int i = 0; i < 4; i++)
	{
		int na = a + dx[i];
		int nb = b + dy[i];
		if (na >= 0 && na < N && nb >= 0 && nb < M) {
			if (arr[na][nb]==bases[level]) {
				dfs(na, nb, level + 1);
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
		string s; cin >> s;
		for (int j = 0; j < M; j++)
		{
			arr[i][j] = s[j]; 
			if (s[j] == 'Y') {
				pv.push_back({ i,j });  
			}
		}
	}
	for (int i = 0; i < pv.size(); i++)
	{
		dfs(pv[i].first, pv[i].second, 1);
	}
	cout << result << "\n"; 

	return 0;
}