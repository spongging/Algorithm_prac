#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;  
typedef long long ll;	 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N; cin >> M >> N;
	vector<ll>v; 
	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num;
		v.push_back(num); 
	}
	sort(v.begin(), v.end());
	ll left = 1; ll right = v[v.size() - 1]; 
	ll result = 0;  
	while (left <= right)
	{
		ll mid = (left + right) / 2;
		ll cnt = 0;
		for (int i = 0; i < v.size(); i++)
		{
			if (v[i] / mid > 0) {
				cnt += v[i] / mid;
			}
		}
		if (cnt >= M) {
			result = max(result, mid); 
			left = mid + 1;
		}
		else right = mid - 1; 
	}
	cout << result << "\n";
	return 0;
}