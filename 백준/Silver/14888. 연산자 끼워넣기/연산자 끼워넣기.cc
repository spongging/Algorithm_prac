#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
using namespace std;

int N;
int arr[101];
int arr2[101];
vector<char>v;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	cin >> N;

	int min = INT_MAX;
	int max = INT_MIN;

	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		arr[i] = num; 
	}

	for (int i = 0; i < 4; i++)
	{
		int num; cin >> num;
		if (i == 0) for (int j = 0; j < num; j++) v.push_back('+');
		if (i == 1) for (int j = 0; j < num; j++) v.push_back('-');
		if (i == 2) for (int j = 0; j < num; j++) v.push_back('*');
		if (i == 3) for (int j = 0; j < num; j++) v.push_back('/');
	}

	sort(v.begin(), v.end());

	do
	{
		copy(arr, arr + N, arr2);
		int result;

		for (int i = 0; i < N - 1; i++)
		{
			int a = arr2[i]; int b = arr2[i + 1];
			char oper = v[i];
			if (oper == '+') result = a + b;
			if (oper == '-') result = a - b;
			if (oper == '*') result = a * b;
			if (oper == '/') result = a / b;
			arr2[i + 1] = result;
		}

		if (result < min) min = result; 
		if (result > max) max = result;

	} while (next_permutation(v.begin(), v.end()));

	cout << max << "\n";
	cout << min << "\n";

	return 0;
}
