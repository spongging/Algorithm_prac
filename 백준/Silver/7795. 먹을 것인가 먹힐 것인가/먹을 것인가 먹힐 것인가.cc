#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T; cin >> T;
	while (T--) 
	{
		vector<int>v; vector<int>v2; 
		int N, M; cin >> N >> M;
		for (int i = 0; i < N; i++)
		{
			int num; cin >> num; 
			v.push_back(num);  
		}
		for (int i = 0; i < M; i++)
		{
			int num; cin >> num;
			v2.push_back(num);
		}
		sort(v.begin(), v.end()); 
		sort(v2.begin(), v2.end());
		int result = 0; 
		for (int i = 0; i < N; i++)
		{
			if (v[i] <= v2[0])continue;
			int left = 0; int right = v2.size() - 1; 
			int mid; 
			while (left <= right)
			{
				mid = (left + right) / 2;
				if (v[i] <= v2[mid]) {
					right = mid - 1;
				}
				else left = mid + 1;
			}
			result += left;
		}
		cout << result << "\n";
	}
	
	return 0;
}