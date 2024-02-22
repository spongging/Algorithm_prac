#include <iostream>
using namespace std;

int N;
bool TF;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	string s; cin >> s;
	int cnt = 0;

	for (int i = 0; i < N - 1; i++)
	{
		char c; c = s[i];
		char c2; c2 = s[i + 1];
		if (c == 'E' && c2 == 'W') cnt++;

	}

	cout << cnt << "\n";

	return 0;
}