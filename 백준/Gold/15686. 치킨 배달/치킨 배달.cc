#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int N, M;
vector<pair<int, int>>house;
vector<pair<int, int>>chiken;
int result = INT_MAX;
vector<int>v;

int func() {
	int sum = 0;
	for (int i = 1; i < house.size(); i++)
	{
		int tmp1 = INT_MAX;
		for (int j = 0; j < v.size(); j++)
		{
			int tmp2 = abs(house[i].first - chiken[v[j]].first) + abs(house[i].second - chiken[v[j]].second);
			if (tmp1 > tmp2) tmp1 = tmp2; 
		}
		sum += tmp1; 
	}
	return sum; 
}

void dfs(int idx, int level) {
	if (level == M) {
		result = min(result, func());
		return;
	}
	for (int i = idx; i < chiken.size(); i++)
	{
		v.push_back(i);
		dfs(i + 1, level + 1);
		v.pop_back();
	}
	return; 
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	house.push_back({ 0,0 });
	chiken.push_back({ 0,0 });

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			int num; cin >> num;
			if (num == 1) {
				house.push_back({ i,j });
			}
			else if (num == 2) {
				chiken.push_back({ i,j }); 
			}
		}
	}

	dfs(1, 0);
	cout << result << "\n";

	return 0;
}