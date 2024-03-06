#include <iostream>
#include <queue>
#include <vector>
#include <cmath>
using namespace std;

int N;

struct comp {
	bool operator()(int a, int b) {
		if (abs(a) == abs(b))
		{
			return a > b;
		}
		else return abs(a) > abs(b);
	}
};


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	priority_queue<int, vector<int>, comp>q; 
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int x; cin >> x;
		if (x == 0)
		{
			if (q.empty())
			{
				cout << 0 << "\n";
			}
			else
			{
				int tmp = q.top();
				q.pop();
				cout << tmp << "\n";
			}

		}
		else q.push(x);
	}

	return 0;
}