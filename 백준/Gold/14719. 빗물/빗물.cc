#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int H, W; cin >> H >> W;
	vector<int>v;
	for (int i = 0; i < W; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}

	if (v.size() == 1 || v.size() == 2) {
		cout << 0 << "\n";
		return 0;
	}

	int pre;
	int i = 1;
	int result = 0;
	while (i < v.size())
	{
		pre = v[i];
		int leftmax = 0;
		int rightmax = 0;
		for (int j = i; j >= 0; j--)
		{
			leftmax = max(leftmax, v[j]);
		}
		for (int j = i; j < v.size(); j++)
		{
			rightmax = max(rightmax, v[j]);
		}
		int tmp = min(leftmax, rightmax) - pre;
		if (tmp >= 0) {
			result += tmp;
		}
		i++;
	}

	cout << result << "\n";

	return 0;
}
