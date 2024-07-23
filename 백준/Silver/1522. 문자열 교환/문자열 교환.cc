#include <iostream>
#include <climits>
using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s; cin >> s;
	int st = 0;
	int cnt = 0;
	int result = INT_MAX; 
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == 'a') cnt++;
	}
	int tmp = 0;
	for (int i = 0; i < cnt; i++)
	{
		if (s[i] == 'b')tmp++;
	}
	result = min(result, tmp); 
	int ed = cnt - 1;
	if (ed < 0) {
		cout << 0;
		return 0;
	}
	while (st != s.length())
	{
		if (s[st] == 'b') tmp--;
		st++;
		ed++;
		if (ed == s.length()) ed = 0;
		if (s[ed] == 'b')  tmp++; 
		result = min(result, tmp); 
	}
	if (result < 0) {
		cout << 0 << "\n";
		exit(0);
	}
	cout << result << "\n";

	return 0;
}