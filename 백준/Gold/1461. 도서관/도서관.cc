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
	vector<int>v2;
	int maxdis;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;  
		if (num < 0) v.push_back(num); 
		else v2.push_back(num); 
	}
	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end(), greater<int>()); 
	if (v.size() > 0 && v2.size() > 0) maxdis = max(v2[0], abs(v[0]));
	else if (v.size() > 0) maxdis = -v[0];
	else maxdis = v2[0]; 
	int sum = 0; 
	int idx1 = 0; int idx2 = 0; 
	while (idx1 < v.size())
	{
		if (v[idx1] == -maxdis) {
			sum += v[idx1];
		}
		else
		{
			sum += (v[idx1] * 2);
		}
		idx1 += M;
	}
	sum = abs(sum);  
	while (idx2 < v2.size())
	{
		if (v2[idx2] == maxdis) {
			sum += v2[idx2]; 
		}
		else
		{
			sum += (v2[idx2] * 2);  
		}
		idx2 += M; 
	}
	cout << sum << "\n";
	return 0;
}