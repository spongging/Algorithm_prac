#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int L; int C; vector<char>path;
bool check() {
	int cnt = 0;
	for (int i = 0; i < L; i++)
	{
		if (path[i] == 'a' || path[i] == 'e' || path[i] == 'i' || path[i] == 'o' || path[i] == 'u')
			cnt++;
	}
	if (cnt >= 1 && (L - cnt) >= 2) return true;
	else return false;
}
void dfs(int index, vector<char>& arr) {
	if (L==path.size())
	{
		if (check())
		{
			for (int k = 0; k < L; k++)
			{
				cout << path[k];
			}

			cout << "\n";
		}
		return;
	}

	for (int i = index; i < C; i++)
	{
		path.push_back(arr[i]);
		dfs(i + 1, arr);
		path.pop_back();
	}
	return;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> L;
	cin >> C;
	vector<char>arr;
	for (int i = 0; i < C; i++)
	{
		char word; cin >> word;
		arr.push_back(word);
	}
	sort(arr.begin(), arr.end());
	dfs(0,arr);
	return 0;
}