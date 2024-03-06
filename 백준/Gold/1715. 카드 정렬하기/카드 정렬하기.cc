#include <iostream>
#include <queue>
using namespace std;

int N;
int result = 0;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	priority_queue<int, vector<int>, greater<int>>pq;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		pq.push(num);
	}

	while (!pq.empty())
	{
		int a = pq.top(); pq.pop();
		if (pq.empty()) break;
		int b = pq.top(); pq.pop();
		int sum = a + b;
		result += sum;
		pq.push(sum);
	}

	cout << result << "\n";

	return 0;
}