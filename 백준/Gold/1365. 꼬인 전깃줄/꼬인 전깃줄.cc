#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	vector<int>v;
	vector<int>list;

	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}

	int i = 1;
	int j = 0;
	list.push_back(v[0]);

	while (i < N)
	{
		if (list[j] >= v[i]) {
			int idx = lower_bound(list.begin(), list.end(), v[i]) - list.begin();
			list[idx] = v[i];
		}
		else
		{
			list.push_back(v[i]);
			j++;
		}
		i++;
	}
	cout << N-list.size() << "\n";

	return 0;
}