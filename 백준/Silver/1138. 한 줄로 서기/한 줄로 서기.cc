#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 


	int N; cin >> N;
	vector<pair<int, int>>pv; 
	vector<int>result; 
	for (int i = 1; i <= N; i++)
	{
		int num; cin >> num;
		pv.push_back({ num,i });
	} 
	sort(pv.begin(), pv.end(), [](const pair<int, int>& a, const pair<int, int>& b) { 
		return a.second > b.second; 
		});  
	result.push_back(pv[0].second);    
	for (int i = 1; i < N; i++)
	{
		if (i > pv[i].first) {
			result.insert(result.begin() + pv[i].first, pv[i].second); 
		}
		else
		{
			result.push_back(pv[i].second);
		}
	}
	for (int i = 0; i < N; i++)
	{
		cout << result[i] << " ";
	}
	cout << "\n";

	return 0;
}