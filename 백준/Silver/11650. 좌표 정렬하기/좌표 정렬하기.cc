#include <iostream>  
#include <vector>
#include <algorithm>
using namespace std;  
int main(void) {
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	int N; cin >> N;
	vector<pair<int, int>>arr;
	for (int i = 0; i < N; i++)
	{
		int a, b;
		cin >> a >> b;
		arr.push_back(make_pair(a, b));
	}
	sort(arr.begin(), arr.end());
	for (int i = 0; i < N; i++)
	{
		cout << arr[i].first << " " << arr[i].second << "\n";
	}
	return 0;
}