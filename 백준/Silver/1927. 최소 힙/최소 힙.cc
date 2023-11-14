#include <iostream>
#include <queue>
#include <functional> 
using namespace std;

int main() {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	
	priority_queue<long long, vector<long long>, greater<long long>> q; 

	int N; cin >> N;
	for (int i = 0; i < N; i++)
	{
		long long num; cin >> num;
		if (num == 0)
		{
			if (q.empty())
			{
				cout << 0 << "\n";
			}
			else
			{
				cout << q.top() << "\n";
				q.pop();
			}
		}
		else
		{
			q.push(num);
		}
	}


	return 0;
}