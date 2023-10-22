#include <iostream>
#include <vector>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<int>nums;
	int N; cin >> N; int aa = 0;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		nums.push_back(num);
	}
	for (int k = 0; k < N; k++)
	{
		int test = nums[k];
		int cnt = 0;
		for (int j = 1; j <= test; j++)
		{
			if (test % j == 0)
			{
				cnt++;
			}
		}
		if (cnt==2)
		{
			aa++;
		}
	}
	cout << aa << "\n";
	return 0;
}