#include <iostream>
#include <queue>
#include <string>
using namespace std;
typedef long long ll; 
queue<ll>q; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int result = 9;
	int N; cin >> N;
	if (to_string(N).length() == 1) {
		cout << N << "\n";    
		exit(0); 
	}
	for (int i = 1; i <= 9; i++) q.push(i); 
	while (!q.empty())
	{
		ll num = q.front();
		q.pop();
		string s = to_string(num);
		int last = s[s.length() - 1] - '0';
		for (int i = 0; i < last; i++)
		{
			result++;
			char c = i + '0';
			q.push(stoll(s + c));
			if (result == N) {
				cout << stoll(s + c) << "\n"; 
				exit(0);
			}
		}
	}
	cout << -1 << "\n";

	return 0;
}