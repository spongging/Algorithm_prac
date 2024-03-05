#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
int arr[1000001];
vector<int>result;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];

	int j = 0;
	int i = 1;
	result.push_back(arr[0]);

	while (i < N) 
	{
		if (result[j] >= arr[i])
		{
			int idx = lower_bound(result.begin(), result.end(), arr[i]) - result.begin();
			result[idx] = arr[i];
		}
		else
		{
			result.push_back(arr[i]);
			j++;
		}
		i++;
	}

	//printing
	cout << j + 1 << "\n";
	return 0;
} 