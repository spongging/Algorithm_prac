#include <iostream>
using namespace std;
int dp[1025][1025];
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M; cin >> N >> M;
	for (int i = 0; i <= N; i++) dp[i][0] = 0;
	for (int i = 0; i <= N; i++) dp[0][i] = 0;
	for (int i = 1; i <= N; i++)
	{
		int sum = 0;
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num;
			sum += num;
			dp[i][j] = sum;
		}
	}

	while (M--)
	{
		int result = 0;
		int x1, y1, x2, y2; cin >> x1 >> y1 >> x2 >> y2; 
		for (int i = x1; i <= x2; i++)
		{
			result += dp[i][y2] - dp[i][y1 - 1];
		}
		cout << result << "\n";
	}

	return 0;
}