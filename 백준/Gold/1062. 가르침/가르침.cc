#include <iostream>
#include <vector>
#include <set>
using namespace std;

int N, K;
vector<string>v;
vector<bool>visited(26, false); // 철자 방문
set<char>addition;
vector<char> additionalchar; // 추가적인 철자 보유
int result = 0;

bool checked(string s) {
	for (int i = 0; i < s.length(); i++)
	{
		if (!visited[s[i] - 'a']) return false;
	}
	return true;
}

void tracking(int idx,int level) {
	if (level == K - 5) {
		int tmp = 0;
		for (int j = 0; j < v.size(); j++)
		{
			if (checked(v[j])) tmp++;
		}
		result = max(result, tmp); 
		return;
	}
	for (int i = idx; i < 26; i++)
	{
		if (!visited[i]) {
			visited[i] = 1;
			tracking(i + 1, level + 1);
			visited[i] = 0;
		}
	}

}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N >> K; 
	for (int i = 0; i < N; i++) {
		string s; cin >> s; 
		v.push_back(s.substr(4, s.length() - 8));
	}
	if (K < 5) {
		cout << 0 << "\n";
		exit(0);
	}

	visited['a' - 'a'] = true;
	visited['c' - 'a'] = true;
	visited['n' - 'a'] = true;
	visited['t' - 'a'] = true;
	visited['i' - 'a'] = true;

	for (int i = 0; i < v.size(); i++) {
		for (char c : v[i]) {
			if (!visited[c - 'a']) {
				addition.insert(c); 
			}
		}
	}

	additionalchar.assign(addition.begin(), addition.end());
	tracking(0, 0);
	cout << result << "\n";

	return 0;
	
}

