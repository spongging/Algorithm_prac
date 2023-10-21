#include <iostream>
#include <vector>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int dp[11];
	dp[0] = 1; dp[1] = 1; dp[2] = 2;
	int n; cin >> n;
	for (int i = 0; i < n; i++)
	{
		int num; cin >> num;
		if (num<=2)
		{
			cout << dp[num] << endl;
		}
		else
		{
			for (int j = 3; j <= num; j++)
			{
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}

			cout << dp[num] << endl;
		}
	}

	return 0;
}