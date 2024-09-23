#include <iostream>
#include <climits>
#include <vector>
#include <algorithm>
using namespace std; 

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	int n, m; cin >> n >> m;
	int c1, c2; cin >> c1 >> c2;
	vector<int>v1;
	vector<int>v2; 
	for (int i = 0; i < n; i++)
	{
		int num; cin >> num;
		v1.push_back(num);
	}
	for (int i = 0; i < m; i++)
	{
		int num; cin >> num;
		v2.push_back(num);  
	}
	sort(v1.begin(), v1.end());
	sort(v2.begin(), v2.end()); 
	int y_dis = abs(c1 - c2); 
	int i = 0; int j = 0; 
	int result = INT_MAX; int resultcnt = 1; 
	while (i < n && j < m)
	{
		int x_dis = abs(v1[i] - v2[j]);
		int tmpresult = x_dis + y_dis;
		if (tmpresult < result)
		{
			result = tmpresult;
			resultcnt = 1;
		}
		else if (tmpresult == result)
		{
			resultcnt++;
		}
		if (v1[i] < v2[j]) {
			i++;
		}
		else
		{
			j++; 
		}
		
	}
	cout << result << " " << resultcnt << "\n"; 

	return 0;
}