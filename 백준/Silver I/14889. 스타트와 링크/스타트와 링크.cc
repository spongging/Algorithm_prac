#include <iostream>
#include <vector>
#include <climits>
#include <cmath>
using namespace std;

int N;
int arr[21][21]; int nums[21];
bool visited[21] = { false };
int result = INT_MAX;

void dfs(int val, int level) {

	vector<int>start;
	vector<int>link;

	if (level > (N / 2))
	{
		int a = 0; int b = 0;
		for (int i = 0; i < N; i++) // dividing each team member
		{
			if (visited[i] == true) start.push_back(i);
			else link.push_back(i);
		}

		for (int i = 0; i < N / 2; i++)
		{
			for (int j = 0; j < N / 2; j++)
			{
				a += arr[start[i]][start[j]];
				b += arr[link[i]][link[j]];
			}
		}

		if (abs(a - b) < result) result = abs(a - b);
		return;

	}

	for (int i = val; i < N; i++)
	{
		if (visited[i] == false)
		{
			visited[i] = true;
			dfs(i, level + 1);
			visited[i] = false;
		}
		else continue;
	};

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
			arr[i][j] = num;
		}
	}

	for (int i = 0; i < N; i++) nums[i] = i; // Initializing a array of nums

	dfs(0, 1);
	cout << result << "\n";

	return 0;
}