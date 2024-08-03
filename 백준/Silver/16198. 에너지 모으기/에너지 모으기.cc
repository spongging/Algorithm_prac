#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;
int N; 
vector<int>v; 
bool visited[11] = { 0 };
ll result = 0;
void dfs(int level, ll sum) {
	if (level == N - 2) {
		result = max(result, sum);
		return; 
	}
	for (int i = 0; i < v.size(); i++)
	{
		if (i == 0 || i == v.size() - 1) continue;
		ll tmp = v[i - 1] * v[i + 1];
		int w = v[i]; 
		v.erase(v.begin() + i); 
		dfs(level + 1, sum + tmp);
		v.insert(v.begin() + i, w);  
	}
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num); 
	}
	dfs(0, 0);
	cout << result << "\n"; 
	return 0;
}