#include <iostream>
using namespace std;
string s; 
bool isPalin(int left, int right) {
	while (left < right)
	{
		if (s[left] != s[right]) return 0;
		left++; right--;
	}
	return 1; 
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int T; cin >> T;
	while (T--)
	{
		cin >> s;
		int st = -1; int ed = s.length();
		bool flag = 0;
		while (1)
		{
			st++; ed--;
			if (st >= ed) {
				cout << 0 << "\n";
				break;
			}
			if (s[st] == s[ed])continue;
			else if (s[st] != s[ed]) {
				flag = 1;
				bool TF1 = isPalin(st + 1, ed);
				bool TF2 = isPalin(st, ed - 1);
				if (TF1 || TF2) {
					cout << 1 << "\n";
					break;
				}
				cout << 2 << "\n";
				break; 
			}
		}

	}

	return 0;
}