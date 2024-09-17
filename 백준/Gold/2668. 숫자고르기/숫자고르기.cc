#include <iostream>
#include <vector>
#include <string.h>
using namespace std; 
int N;
int arr[101];
bool visited[101] = { 0 }; 
vector<int>result;
void dfs(int num, int init) {
	
	if (visited[num]) {
		if (num == init) {
			result.push_back(num);  
		}
		return; 
	}

	visited[num] = 1;
	dfs(arr[num], init);
	return;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	cin >> N;
	for (int i = 1; i <= N; i++)
	{
		int num; cin >> num;
		arr[i] = num;  
	}
	for (int i = 1; i <= N ; i++)
	{
		memset(visited, 0, sizeof(visited));
		dfs(i, i);
	}
	cout << result.size() << "\n";
	for (auto n : result) cout << n << "\n";
	return 0;
}