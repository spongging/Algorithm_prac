#include <iostream>
#include <stack>
using namespace std;

void vps(string s) {

	stack<char>ss;
	if (s[0] == ')')
	{
		cout << "NO" << "\n";
		return;
	}
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == '(')
		{
			ss.push(s[i]);
		}
		else
		{
			if (ss.empty()) 
			{
				cout << "NO" << "\n";
				return;
			}
			ss.pop();
		}
	}
	if (ss.empty()) 
	{
		cout << "YES" << "\n";
		return;
	}
	else
	{
		cout << "NO" << "\n";
		return;
	}

}

int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 
	
	int t; cin >> t;
	for (int i = 0; i < t; i++)
	{
		string s; cin >> s;
		vps(s);
	}

	return 0;
}