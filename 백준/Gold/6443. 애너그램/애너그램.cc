#include <iostream>
#include <algorithm>
using namespace std;

int N;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		string s; cin >> s;
		sort(s.begin(), s.end());
		do
		{
			cout << s << "\n";
		} while (next_permutation(s.begin(), s.end()));
	}
	
	return 0;
}
