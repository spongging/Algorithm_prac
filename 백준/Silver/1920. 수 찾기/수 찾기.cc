#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>arr; vector<int>arr2;

void func(int input) {
	int start = 0; int end = arr.size() - 1; 
	int mid;
	while (end >= start)
	{
		mid = (start + end) / 2;
		if (arr[mid] == input)
		{
			cout << 1 << "\n";
			return;
		}
		else if (arr[mid] > input) end = mid - 1;
		else start = mid + 1;
	}
	cout << 0 << "\n";
	return;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	for (int i = 0; i < N; i++)
	{
		int input;cin >> input;
		arr.push_back(input);
	}
	sort(arr.begin(), arr.end());
	int M; cin >> M;
	for (int i = 0; i < M; i++)
	{
		int input; cin >> input;
		func(input);
	}
	return 0;
}