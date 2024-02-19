#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
bool board[11][11] = { false };
int result1, result2;
int cntB = 0, cntW = 0;
bool visited[11][11] = { false };
vector<bool>lEft = { false };
vector<bool>rIght = { false };

// 0 black column - even // 1 white column - odd

void dfs(int a, int b, int cnt, int divison) {

	if (b >= N) {
		if (b % 2 == 0) b = 1;
		else b = 0;
		a += 1;
	}

	if (a >= N && (divison==0)) {
		cntB = max(cntB, cnt);
		return;
	}

	if (a >= N && (divison == 1)) {
		cntW = max(cntW, cnt);
		return;
	}


	if (board[a][b] && !lEft[b + a] && !rIght[a - b + N + 1]) {
		lEft[b + a] = true; rIght[a - b + N + 1] = true;
		dfs(a, b + 2, cnt + 1, divison);
		lEft[b + a] = false; rIght[a - b + N + 1] = false;
	}
	dfs(a, b + 2, cnt, divison);

}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			int num; cin >> num;
			if (num == 1)  board[i][j] = true; 
		}
	}

	dfs(0, 0, 0, 0);
	dfs(0, 1, 0, 1);

	cout << cntB + cntW << "\n";

	return 0;
}