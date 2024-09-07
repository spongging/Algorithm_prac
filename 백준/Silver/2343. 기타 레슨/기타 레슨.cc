#include <iostream>
#include <vector>
using namespace std;  
typedef long long ll;  
 int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL); 

	int N, M; cin >> N >> M;
	vector<int>v; 
	ll maxval = 0; ll sum = 0;
	for (int i = 0; i < N; i++)
	{
		ll num; cin >> num;
		v.push_back(num);  
		maxval = max(maxval, num);
		sum += num; 
	}
	ll left = maxval; ll right = sum;  
	while (left <= right)
	{
		ll mid = (left + right) / 2; 
		ll cost = 0; int cnt = 0;  
		for (int i = 0; i < N; i++) 
		{
			if (cost < v[i]) {
				cost = mid;
				cnt++;
			}
			if (cost >= v[i]) cost -= v[i]; 
		}
		if (cnt > M) left = mid + 1;
		else right = mid - 1; 
	}
	cout << left << "\n"; 
	return 0;
}