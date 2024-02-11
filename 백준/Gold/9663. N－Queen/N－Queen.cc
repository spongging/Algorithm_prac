#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int N, result = 0;
int arr[15];

bool check(int tmp) { // arr[tmp] is fixed

	for (int i = 0; i < tmp; i++)
	{
		if (arr[i] == arr[tmp] || tmp - i== abs(arr[tmp] - arr[i])) return false;
	}
	return true;
}

void dfs(int x) {
	if (x == N) result++;  
	for (int i = 0; i < N; i++)
	{
		arr[x] = i; // i is number of row And x is column // a[0] = 0  a[1] = 1
		if (check(x)) dfs(x + 1);
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N; 
	dfs(0);
	cout << result << "\n";

	return 0;
}