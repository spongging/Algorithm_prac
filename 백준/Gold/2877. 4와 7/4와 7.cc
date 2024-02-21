#include <iostream>
#include <vector>
using namespace std;

int K;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> K;
	vector<int>v;
	int tmp = K + 1;

	while (tmp != 0)
	{
		int remain = tmp % 2;
		int dive = tmp / 2;

		v.push_back(remain);

		tmp = dive;
	}

	v.pop_back();
	vector<int>v2;

	for (int i = v.size() - 1; i >= 0; i--)
	{
		int num = v[i];
		if (num == 1) v2.push_back(7);
		else v2.push_back(4);
	}

	for (int i : v2) {
		cout << i;
	}
	cout << "\n";

	return 0;
}