#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N; cin >> N; 
	vector<pair<ll, ll>>v; 
	ll tmp = 0; 
	for (int i = 0; i < N; i++)
	{
		ll X, A; cin >> X >> A;
		tmp += A; 
		v.push_back(make_pair(X, A));
	}
	sort(v.begin(), v.end());
	if (tmp % 2 == 0)tmp = tmp / 2;
	else tmp = tmp / 2 + 1;
	ll sum = 0; 
	for (int i = 0; i < N; i++) 
	{
		sum += v[i].second;
		if (sum >= tmp) {
			cout << v[i].first << "\n";
			return 0; 
		}
	}
	
	return 0;
}