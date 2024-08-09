#include <iostream>	
#include <vector>
using namespace std;
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int T; cin >> T;
	
	while (T--)
	{
		vector<int>v(26, 0);
		vector<int>v2(26, 0);
		string result; cin >> result;
		string origin; cin >> origin;
		bool flag = 0; 
		int st = 0; 
		int ed = 0;
		for (int i = 0; i < origin.length(); i++) v[origin[i] - 'a']++;
		for (int i = 0; i < origin.length(); i++) v2[result[i] - 'a']++;
		if (v == v2) {
			cout << "YES" << "\n";
			continue;
		}
		for (int i = origin.length(); i < result.length(); i++)
		{
			v2[result[i - origin.length()]-'a']--;
			v2[result[i]-'a']++;
			if (v == v2) {
				flag = 1;
				break;
			}
		}
		if (flag) {
			cout << "YES" << "\n";
		}
		else cout << "NO" << "\n"; 
	}
	return 0;
}