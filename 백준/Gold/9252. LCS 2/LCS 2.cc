#include <iostream>
#include <vector>
using namespace std;

string s1, s2;
vector<char>result;
int dp[1001][1001];

void init() {
	for (int i = 0; i < 1001 ; i++)
	{
		dp[i][0] = 0;
		dp[0][i] = 0;
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s1 >> s2;
	init(); 

	// getting length
	for (int i = 1; i <= s1.length(); i++)
	{
		for (int j = 1; j <= s2.length(); j++)
		{
			if (s1[i - 1] != s2[j - 1]) dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			else dp[i][j] = dp[i - 1][j - 1] + 1;
		}
	}

	cout << dp[s1.length()][s2.length()] << "\n";

	// getting LCS

	int tmpidx = s2.length();
	for (int i = s1.length(); i >= 1; i--)
	{
		for (int j = tmpidx; j >= 1; j--)
		{
			if (dp[i][j] == dp[i][j - 1]) continue;
			else if (dp[i][j] == dp[i - 1][j]) {
				tmpidx = j;
				break;
			}
			else
			{
				result.push_back(s2[j - 1]);
				tmpidx = j - 1;
				break;
			}
		}
	}

	//printing LCS

	for (int i = result.size()-1; i >= 0; i--)
	{
		cout << result[i];
	}
	cout << "\n";

	return 0;
}