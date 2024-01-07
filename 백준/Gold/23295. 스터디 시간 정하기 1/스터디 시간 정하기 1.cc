#include <iostream>
#include <vector>
typedef long long ll;
using namespace std;
int arr[100001] = { 0 };
ll sum[100001] = { 0 };
int main(void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, T; cin >> N >> T;
	
	for (int i = 0; i < N; i++)
	{
		int K; cin >> K;
		for (int j = 0; j < K; j++)
		{
			int a, b; cin >> a >> b; 
			arr[a] += 1, arr[b] += -1;
		}
	}
	for (int i = 1; i < 100001; i++)
	{
		arr[i] += arr[i - 1];
	}
	sum[0] = arr[0];
	for (int i = 1; i < 100001; i++)
	{
		sum[i] += sum[i - 1] + arr[i]; 
	}
	
	int st = 1; 
	ll result = sum[T - 1];
	int left = 0, right = T; 
	while (st < 100001 - T)
	{
		int ed = st + T - 1;
		ll tmp = sum[ed] - sum[st - 1];
		if (result < tmp)
		{
			left = st; right = ed + 1;
			result = max(result, tmp);  
		}
		st++;
	}
	cout << left << " " << right << "\n";
	return 0;
}