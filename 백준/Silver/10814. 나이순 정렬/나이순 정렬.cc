#include <iostream>  
#include <vector>
#include <algorithm>
using namespace std;  
int main(void) {
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	int N; cin >> N;
	vector<pair<int, string>>arr;
	for (int i = 0; i < N; i++)
	{
		int a; string b;
		cin >> a >> b; 
		arr.push_back(make_pair(a, b));
	}
	auto customCompare = [](const pair<int, string>& a, const pair<int, string>& b) {
		return a.first < b.first; 
	};
	
	stable_sort(arr.begin(), arr.end(), customCompare);
	for (int i = 0; i < N; i++)
	{
		cout << arr[i].first << " " << arr[i].second << "\n";
	}
	return 0;
}