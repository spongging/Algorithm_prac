#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>>v;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	int x, y;
	int arr[51] = {0};
	for (int i = 0; i < N; i++)
	{
		cin >> x >> y;
		v.push_back(make_pair(x, y));  
	}
	for (int i = 0; i < N; i++)
	{
		pair<int, int>p = v[i];
		for (int j = 0; j < N; j++)
		{
			if (p.first < v[j].first && p.second < v[j].second) {
				arr[i] += 1;
			}
		}
	}

	for (int i = 0; i < N; i++)
	{
		cout << arr[i]+1 << " ";
	}
	return 0;
}