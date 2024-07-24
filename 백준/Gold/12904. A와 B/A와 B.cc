#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S, T; 
	cin >> S;  
	cin >> T;  
	bool flag = 0; 

	for (int i = T.length() - 1; i >= 0; i--)
	{
		if (T[i] == 'A') {
			T.erase(i);
			if (S == T) {
				flag = 1;
				break;
			}
		}
		else
		{
			T.erase(i);
			reverse(T.begin(), T.end());
			if (S == T) {
				flag = 1;
				break;
			}
		}
	}
	if (flag) cout << 1 << "\n";
	else cout << 0 << "\n";

	return 0;
}