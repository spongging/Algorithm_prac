#include <iostream>
#include <queue>
using namespace std;
typedef long long ll;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	priority_queue<ll, vector<ll>, greater<ll>>pq;

	for (int i = 0; i < N * N; i++)
	{
		ll num; cin >> num;
		pq.push(num);
		if (pq.size()> N)
		{
			pq.pop();
		}
	}


	cout << pq.top() << "\n";
	
	return 0;
}
