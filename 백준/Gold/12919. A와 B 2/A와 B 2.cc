#include <iostream>
#include <algorithm>
#include <string>
using namespace std; 
string base;
string target; 
bool flag = 0;
void func(string s) {
	if (s == base) {
		flag = 1;
		return; 
	}
	if (base.length() >= s.length()) return;
	if (s[s.length() - 1] == 'A') {
		string tmp = s;
		tmp.erase(tmp.length() - 1);
		func(tmp);
	}
	if (s[0] == 'B') {
		string tmp = s;
		tmp.erase(tmp.begin());
		reverse(tmp.begin(), tmp.end());
		func(tmp);
	}
	return;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	cin >> base;
	cin >> target; 
	
	func(target); 
	if (!flag)cout << 0 << "\n";
	else cout << 1 << "\n";

	return 0;
}