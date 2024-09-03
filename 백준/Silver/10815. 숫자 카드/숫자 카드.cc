#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N; 
	vector<int>v; 
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num); 
	}
	sort(v.begin(), v.end()); 
	int M; cin >> M;
	while (M--)
	{
		int target; cin >> target; 
		int left = 0; int right = v.size() - 1;
		int mid; 
		bool flag = 0; 
		while (left<=right)
		{
			mid = (left + right) / 2; 
			if (v[mid] == target) {
				flag = 1; 
				break; 
			}
			else if (v[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1; 
			}
		}
		if (flag) cout << 1 << " ";
		else cout << 0 << " ";
	}
	cout << "\n"; 
	return 0;
}