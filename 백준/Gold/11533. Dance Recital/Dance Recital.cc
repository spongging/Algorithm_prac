#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	int N; cin >> N;
	vector<string>v;  
	vector<int>idx; 
	int result = INT_MAX;
	for (int i = 0; i < N; i++)
	{
		string s; cin >> s;
		v.push_back(s); 
	}
	for (int i = 0; i < N; i++) idx.push_back(i); 
	do
	{
		int cnt = 0; 
		for (int i = 0; i < N - 1; i++)
		{
			for (int j = 0; j < v[idx[i]].length(); j++)
			{
				char c = v[idx[i]][j];
				for (int k = 0;  k < v[idx[i+1]].length();  k++)
				{
					if (c == v[idx[i + 1]][k]) {
						cnt++;
						break;
					}
				}
			}
			if (cnt >= result) break;
		}
		result = min(result, cnt); 
	} while (next_permutation(idx.begin(),idx.end()));
	cout << result << "\n";
	return 0;
}