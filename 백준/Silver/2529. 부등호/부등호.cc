#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
int K;
vector<int>v;
vector<string>result;
vector<char>sign;
bool visited[10] = { 0 };
void func() {
	string s;
	for (int i = 0; i < v.size() - 1; i++)
	{
		if (v[i] < v[i + 1]) {
			if (sign[i] == '<') continue;
			else return;
		}
		else
		{
			if (sign[i] == '>') continue;
			else return;
		}
	}
	for (int i = 0; i < v.size(); i++)
	{
		s += v[i] + '0';
	}
	result.push_back(s);  
	return;
}
void dfs(int level) {

	if (level > K ) {
		func(); 
		return;
	}
	for (int i = 0; i < 10; i++)
	{
		if (!visited[i]) {
			v.push_back(i);
			visited[i] = 1;
			dfs(level + 1);
			v.pop_back();
			visited[i] = 0;
		}
	}
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> K; 
	for (int i = 0; i < K; i++)
	{
		char c; cin >> c;
		sign.push_back(c); 
	}
	dfs(0);
	sort(result.begin(), result.end());
	cout << result.back() << "\n"; 
	cout << result.front() << "\n";
	return 0;
}