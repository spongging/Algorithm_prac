#include <iostream>  
#include <vector>
#include <algorithm>
using namespace std;  
int main(void) {
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	int N; cin >> N;
	vector<pair<int, int>>line;
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		line.push_back(make_pair(a, b)); 
	}
	sort(line.begin(), line.end()); 
	int start, end, length = 0; 
	start = line[0].first;
	end = line[0].second; 
	int i = N;
	for (int j = 1; j < N; j++)
	{
		if (line[j].first <= end)
		{
			if (line[j].second > end)
			{
				end = line[j].second;
			}
		}
		else
		{
			length += end - start;
			start = line[j].first;
			end = line[j].second; 
		}
	}
	length += end - start;
	cout << length << "\n";
	return 0;
}