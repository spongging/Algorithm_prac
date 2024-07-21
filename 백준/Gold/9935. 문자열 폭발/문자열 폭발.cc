#include <iostream>
#include <vector>
using namespace std;
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s; cin >> s;
	string target; cin >> target;
	vector<char>result;
	for (char c : s) { 
		result.push_back(c);
		bool flag = 1;
		if (result.size() >= target.length()) {
			for (int i = 0; i < target.length(); i++)
			{
				if (result[result.size() - target.length() + i] != target[i]) {
					flag = 0;
					break;
				}
			}
			if (flag) {
				for (int i = 0; i < target.length(); i++)
				{
					result.pop_back();
				}
			}
		}
	}

	if (result.size() == 0) {
		cout << "FRULA" << "\n";
		exit(0);
	}
	for (char c : result) {
		cout << c;
	}
	cout << "\n";
	return 0;
}