#include <iostream>
#include <vector>
#include <algorithm>
typedef long long ll;
using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	vector<ll>v; 
	ll result = 0;
	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num;
		v.push_back(num); 
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < N - 1; i++)
	{
		ll a = v[i];
		ll b = v[i + 1];
		ll c = v[N - 1];
		result = max(result, abs(a - 2 * b + c));
	}

	for (int i = N - 1; i > 1; i--)
	{
		ll a = v[0];
		ll b = v[i - 1];
		ll c = v[i];
		result = max(result, abs(a - 2 * b + c));
	}
	cout << result << "\n";
	return 0;
}