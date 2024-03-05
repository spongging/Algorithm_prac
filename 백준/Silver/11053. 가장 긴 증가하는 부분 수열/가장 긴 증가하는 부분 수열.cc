#include <iostream>
using namespace std;

int N;
int arr[1000001];
int dp[1000001];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];

	for (int i = 0; i < N; i++)
	{
		dp[i] = 1;

		for (int j = 0; j < i; j++)
		{
			if (arr[i] > arr[j]) dp[i] = max(dp[i], dp[j] + 1);
		}
	}

	int result = 0;
	for (int i = 0; i < N; i++)
	{
		if (result < dp[i]) result = dp[i];
	}
	cout << result << "\n";
	return 0;
} 