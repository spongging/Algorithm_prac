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
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		pv.push_back({ a,b });
	}
	sort(pv.begin(), pv.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
		return a.first > b.first;
		});
	int cnt = 0; int idx;
	for (int i = 0; i < N; i++)
	{
		cnt++; 
		if (cnt == 5) {
			idx = i;
			break;
		}
	}
	int result = 0;
	for (int i = idx+1; i < N; i++)
	{
		if (pv[i].first == pv[idx].first) {
			result++;
		}
		else break;
	}
	cout << result << "\n";
	return 0;
}