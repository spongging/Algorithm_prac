#include <iostream>
#include <queue>
bool del[100001] = { 0 };
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	int N; cin >> N;
	priority_queue<pair<int, int>>pq1;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq2;
	for (int i = 0; i < N; i++)
	{
		int P, L; cin >> P >> L;
		pq1.push({ L,P });
		pq2.push({ L,P });
	}
	int M; cin >> M;
	while (M--)
	{
		string s; cin >> s;
		if (s == "add") {
			int a, b; cin >> a >> b;
			pq1.push({ b,a });
			pq2.push({ b,a });
		}
		else if (s == "recommend") {
			int a; cin >> a;
			if (a == 1) {
				bool flag = 0;
				while (!flag) 
				{
					if (del[pq1.top().second] == 1) {
						del[pq1.top().second] = 0;
						pq1.pop();
						continue;
					}
					flag = 1;
				}
				cout << pq1.top().second << "\n";
			}
			else
			{
				bool flag = 0;
				while (!flag)
				{
					if (del[pq2.top().second] == 1) {
						del[pq2.top().second] = 0;
						pq2.pop();
						continue;
					}
					flag = 1;
				}
				cout << pq2.top().second << "\n";
			}
		}
		else
		{
			int number; cin >> number;
			del[number] = 1; 
		}
	}

	return 0;
}