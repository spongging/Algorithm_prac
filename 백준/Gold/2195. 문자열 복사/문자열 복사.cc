#include <iostream>
using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string S, P; cin >> S >> P;
	int result = 0; 
	for (int i = 0; i < P.length(); i++)
	{
		int maxcnt = 0;
		result++;
		for (int j = 0; j < S.length(); j++)
		{
			int cnt = 0; 
			while (j + cnt < S.length() && i + cnt < P.length() && S[j + cnt] == P[i + cnt])
			{
				cnt++;
			}
			maxcnt = max(maxcnt, cnt);
		}
		i += (maxcnt-1);
	}
	cout << result << "\n";

	return 0;
}