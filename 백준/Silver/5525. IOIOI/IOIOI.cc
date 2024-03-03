#include <iostream>
using namespace std;

int N, M, len;
string s;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M; 
	cin >> s;  

	int result = 0;
	int cnt = 0;

	for (int i = 0; i < M; i++)
	{
		if (s[i] == 'I') {

			while (s[i + 1] == 'O' && s[i + 2] == 'I')
			{
				cnt++;
				if (cnt == N)
				{
					result++;
					cnt--;
				}
				i += 2;
			}
			cnt = 0;
		}
	}

	cout << result << "\n"; 

	return 0;
}