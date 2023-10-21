#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<long long>arr;
	int K; int N;
	cin >> K >> N;
	for (int i = 0; i < K; i++) {
		long long num; cin >> num; arr.push_back(num);
	}
	long long left = 1; 
	long long right = *max_element(arr.begin(), arr.end());
	long long result = 0;
	while (left<=right)
	{
		long long mid = (left + right) / 2;
		long long sum = 0;
		for (int i = 0; i < K; i++)
		{
			sum += (arr[i] / mid);
		}
		if (sum >= N)
		{
			result = mid;
			left = mid + 1;

		}
		else
		{
			right = mid - 1;
		}
	}
	cout << result << "\n";
	return 0;
}