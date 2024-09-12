#include <iostream>
#include <stack>
using namespace std; 
typedef long long ll;  
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	string s1; cin >> s1; 
	stack<char>s; 
	ll cnt = -1;
	ll result = 0; 
	for (int i = 0; i < s1.length(); i++)
	{
		if (s1[i] == '(') {
			cnt++; 
			s.push(s1[i]);
		}
		else
		{
			if (s1[i] == ')') {
				if (s1[i - 1] == ')') {
					s.pop();
					cnt--; 
				}
				else
				{
					s.pop(); 
					result += cnt;
					cnt--;
				}
			}
			
		}
	}
	cout << result << "\n"; 
	return 0;
}