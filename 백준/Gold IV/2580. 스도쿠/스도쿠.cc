#include <iostream>
#include <vector>
using namespace std;

int board[10][10];
vector<pair<int, int>>v;

bool TF(int a, int b, int val) {

	for (int i = 1; i <= 9; i++)
	{
		if (board[a][i] == val) return false;  // Finding same number in row
		if (board[i][b] == val) return false;  // Finding same number in column

		int aa = (a - 1) / 3 * 3 + (i - 1) / 3 + 1;
		int bb = (b - 1) / 3 * 3 + (i - 1) % 3 + 1;

		if (board[aa][bb] == val) return false; // Finding same number in 3*3 area
	}

	return true;
}

void dfs(int idx) {

	if (idx == v.size()) { // Prevent to overflow of finding vector and that means already found
																			 // all empty square
		
		for (int i = 1; i <= 9; i++) // Printing a final board
		{
			for (int j = 1; j <= 9; j++)
			{
				cout << board[i][j] << " ";
			}
			cout << "\n";
		}
		exit(0);
	}

	int a = v[idx].first;
	int b = v[idx].second;

	for (int i = 1; i <= 9; i++)
	{
		if (TF(a, b, i)) {
			board[a][b] = i;
			dfs(idx + 1);
			board[a][b] = 0;
		}
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 9; i++)
	{
		for (int j = 1; j <= 9; j++)
		{
			int num; cin >> num;
			if (num == 0) v.push_back(make_pair(i, j));
			board[i][j] = num;
		}
	}

	dfs(0);

	return 0;
}