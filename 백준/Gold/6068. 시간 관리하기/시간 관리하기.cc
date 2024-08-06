#include <iostream>
#include <vector>
#include <algorithm>	
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N; cin >> N; 
	vector<pair<int, int>>v;
	for (int i = 0; i < N; i++)
	{
		int T, S; cin >> T >> S;
		v.push_back({ S,T }); 
	}
	sort(v.begin(), v.end()); 
	int result = -1;
	bool flag = 0;
	while (1)
	{
		int time = result;
		time++; 
		for (int i = 0; i < N; i++)
		{
			if (time + v[i].second <= v[i].first) {
				time += v[i].second;
			}
			else flag = 1;
			
		}
		if (flag) break;
		result++;
	}
	cout << result << "\n";
	return 0;
}