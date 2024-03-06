#include <iostream>
#include <queue>
using namespace std;

int N, cnt = 0;
priority_queue<int>q;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		if (num == 0) {
			if (q.empty()) cout << 0 << "\n";
			else
			{
				int tmp = q.top();
				q.pop();
				cout << tmp << "\n";
			}
		}
		else q.push(num);
	}

	return 0;
}