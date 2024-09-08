#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;  
typedef long long ll;  
 int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL); 

	int N, K; cin >> N >> K;
	vector<ll>v; 
	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num; 
		v.push_back(num); 
	}
	sort(v.begin(), v.end());  
	ll left = 1; ll right = v[v.size() - 1]; 
	while (left <= right) 
	{
		ll mid = (left + right) / 2;
		int cnt = 0; 
		for (int i = 0; i < N; i++)
		{
			if (v[i] / mid > 0) {
				cnt += (v[i] / mid);
			}
		}
		if (cnt >= K)left = mid + 1;
		else right = mid - 1; 
	}
	cout << left-1 << "\n"; 
	return 0;
}