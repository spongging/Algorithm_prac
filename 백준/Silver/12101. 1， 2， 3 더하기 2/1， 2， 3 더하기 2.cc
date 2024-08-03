#include <iostream>
#include <vector>
using namespace std;
int arr[3] = { 1,2,3 };
int n, k;
vector<int>v;
int cnt = 0;
void dfs(int sum) {
	if (sum == n) {
		cnt++;
		if (cnt == k) {
			for (int i = 0; i < v.size(); i++)
			{
				cout << v[i];
				if (i != v.size() - 1) {
					cout << "+";
				}
			}
			exit(0);
		}
		else return;
	}
	for (int i = 0; i < 3; i++)
	{
		if (sum + arr[i] <= n) {
			v.push_back(arr[i]);
			dfs(sum + arr[i]);
			v.pop_back(); 
		}
	}
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	dfs(0);
	cout << -1 << "\n";

	return 0;
}