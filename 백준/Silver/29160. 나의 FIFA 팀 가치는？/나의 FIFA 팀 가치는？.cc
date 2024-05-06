#include <iostream>
#include <vector>
#include <queue>
#include <map>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, K; cin >> N >> K;
	priority_queue<int, vector<int>>q[12];
	map<int, int>m;
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		q[a].push(b); 
	}
	while (K--)
	{
		for (int i = 1; i <= 11; i++) //3
		{
			if (q[i].empty()) m[i] = 0;
			else
			{
				int tmp = q[i].top();
				m[i] = tmp;
				q[i].pop();
				tmp--; q[i].push(tmp);
			}
		}

		for (int i = 1; i <= 11; i++)
		{
			if (q[i].empty()) m[i] = 0;
			else
			{
				m[i] = q[i].top();
			}
		}
	}

	int result = 0;
	for (int i = 1; i <= 11; i++)
	{
		result += m[i];
	}
	cout << result << "\n";
	return 0;
}

