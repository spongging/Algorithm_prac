#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;  
 int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M; cin >> N >> M;
	vector<int>v; 
	int sum = 0; int maxval = 0;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num; 
		v.push_back(num); 
		sum += num;
		maxval = max(maxval, num); 
	}
	int left = maxval; int right = sum;
	while (left <= right)
	{
		int mid = (left + right) / 2;
		int cost = 0; 
		int cnt = 0; 
		bool flag = 0; 
		for (int i = 0; i < v.size(); i++)
		{
			if (cost < v[i]) {
				cost = mid;
				cnt++; 
			}
			if (cost >= v[i]) {
				cost -= v[i];
			}
			else {
				flag = 1;
				break;
			}
		}
		if (flag || cnt > M) {
			left = mid + 1;
		}
		else right = mid - 1;  
	}
	cout << left << "\n";
	return 0;
}