#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n,d;
vector<pair<int, int>>v;
priority_queue<int, vector<int>, greater<int>>pq;
int answer = 0; 
bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second != b.second) {
		return a.second < b.second;
	}
	else if (a.second == b.second) {
		return a.first < b.first;
	}
}
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int st, ed; cin >> st >> ed;
		if (st > ed) v.push_back({ ed,st }); 
		else v.push_back({ st,ed });
	}

	sort(v.begin(), v.end(), compare);
	cin >> d;
	
	for (int i = 0; i < n; i++)
	{

		if (v[i].second - v[i].first <= d) {
			pq.push(v[i].first);
			while (!pq.empty())
			{
				if (v[i].second - pq.top() > d) {
					pq.pop();
				}
				else break;
			}
		}
		answer = max(answer, (int)pq.size());
	}

	cout << answer << "\n";

	return 0;
}

