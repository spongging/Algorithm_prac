#include <iostream>
#include <queue>
using namespace std; 

int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	int t; cin >> t;
	while (t--)
	{
		int n, m; cin >> n >> m;
		queue<pair<int, int>>list;
		priority_queue<int>importent;
		for (int i = 0; i < n; i++)
		{
			int num; cin >> num;
			importent.push(num);
			list.push(make_pair(i, num));
		}

		int cnt = 1;
		while (1)
		{
			if (list.front().second < importent.top())
			{
				list.push(list.front());
				list.pop();
			}
			else if (list.front().second == importent.top())
			{
				if (list.front().first == m)
				{
					break;
				}
				else
				{
					list.pop(); importent.pop();
					cnt++;
				}
			}
		}
		cout << cnt << "\n";
	}
	return 0;
}