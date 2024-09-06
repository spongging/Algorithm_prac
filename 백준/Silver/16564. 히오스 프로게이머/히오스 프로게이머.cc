#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;  
typedef long long ll; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<ll>v;
	int N; ll K; 
	cin >> N >> K; 
	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num;
		v.push_back(num); 
	}
	sort(v.begin(), v.end()); 
	ll left = v[0]; ll right = v[v.size() - 1] + K;
	ll result = left; 
	while (left <= right)
	{
		ll mid = (left + right) / 2; 
		ll sum = 0;  
		for (int i = 0; i < N; i++)
		{
			if(mid>=v[i]) sum += (mid - v[i]);
		}
		if (sum <= K) {
			result = mid;  
			left = mid + 1;
		}
		else { 
			right = mid - 1;
		}
	}
	cout << result << "\n";
	
	return 0;
}