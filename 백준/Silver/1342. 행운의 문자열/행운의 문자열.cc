#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

string s;
int cnt = 0;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s; 
	sort(s.begin(), s.end());

	if (s.length() == 1) {
		cout << 1 << "\n";
		return 0;
	}
	do {
		for (int i = 0; i < s.length() - 1; i++)
		{
			if (s[i] == s[i + 1]) break;
			if (i == s.length() - 2) cnt++; 
		}
	} while (next_permutation(s.begin(), s.end()));

	cout << cnt << "\n";
	return 0;

} 
