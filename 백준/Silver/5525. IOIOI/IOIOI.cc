#include <iostream>
using namespace std;

int N, M, len;
string s;
int result = 0;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	cin >> s;

	for (int i = 0; i < M; i++)
	{
		if (s[i] == 'I') {

			int cnt = 0;
			int init = i;

			while (s[init + 1] == 'O' && s[init + 2] == 'I')
			{
				cnt++; 
				if (cnt == N)
				{
					result++;  
					break;
				}
				init += 2;
			}
		}
	}

	cout << result << "\n";

	return 0;
}