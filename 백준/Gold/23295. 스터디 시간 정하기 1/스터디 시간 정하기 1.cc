#include <iostream>
#include <vector>
typedef long long ll;
using namespace std;
ll arr[100001] = { 0 };
ll sum[100001] = { 0 };
int main(void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	ll N, T; cin >> N >> T;
	
	for (ll i = 0; i < N; i++)
	{
		ll K; cin >> K;
		for (ll j = 0; j < K; j++)
		{
			ll a, b; cin >> a >> b; 
			arr[a] += 1, arr[b] += -1;
		}
	}

	for (ll i = 1; i < 100001; i++)
	{
		arr[i] += arr[i - 1];
	}

	sum[0] = arr[0];
	for (ll i = 1; i < 100001; i++)
	{
		sum[i] += sum[i - 1] + arr[i]; 
	}
	
	ll st = 1; ll ed;
	ll result = sum[T - 1];
	ll left = 0, right = T; 
	while (st < 100001 - T)
	{
		ll tmp = sum[st + T - 1] - sum[st - 1];
		if (result < tmp)
		{
			left = st; right = st + T;
		}
		result = max(result, tmp); 
		st++;
	}
	cout << left << " " << right << "\n";
	return 0;
}