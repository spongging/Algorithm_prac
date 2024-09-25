#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
typedef long long ll;  

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	vector<pair<int, int>>input;
	input.push_back({ 0,0 }); 
	int n, k; cin >> n >> k;

	for (int i = 1; i <= n; i++)
	{
		int a, b; cin >> a >> b;
		input.push_back({ a,b }); 
	}
	vector<int>visit;
	for (int i = 0; i < k; i++)
	{
		int num; cin >> num;
		visit.push_back(num); 
	}
	sort(input.begin(), input.end());

	vector<pair<int,int>>interval(100000); 
	interval[0] = { 0,0 };

	int part[100001] = { 0 }; part[1] = 1;
	int start = input[1].first;
	int end = input[1].second; 
	int idx = 1; // 통합한 구간의 인덱스 저장용 

	for (int i = 2; i <= n; i++)
	{
		if (input[i].first <= end) {
			if (input[i].second > end) {
				end = input[i].second;
			}
			part[i] = idx;
		}
		else
		{
			interval[idx] = { start,end };
			start = input[i].first;
			end = input[i].second; 
			idx++;
			part[i] = idx;
		}
		if (i == n) {
			interval[idx]= { start,end }; 
		}
	}

	ll result = 0; 
	ll prefix[100001]; prefix[0] = 0; prefix[1] = 0; 
	for (int i = 2; i <= idx; i++)
	{
		prefix[i] = prefix[i-1] + interval[i].first - interval[i - 1].second;
	}
	for (int i = 0; i < k - 1; i++)
	{
		if (part[visit[i]] != part[visit[i + 1]]) {
			result += abs(prefix[part[visit[i]]] - prefix[part[visit[i + 1]]]);
		}
	}
	result += abs(prefix[part[1]] - prefix[part[visit[0]]]);
	cout << result << "\n";
	return 0;
}