#include <iostream>
#include <queue>
using namespace std;


int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;  int M; cin >> N >> M;
	int arr[100001];
	priority_queue<int>pq;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		pq.push(num);
	}
	for (int i = 0; i < M; i++)
	{
		int num; cin >> num;
		arr[i] = num;
	}
	for (int i = 0; i < M; i++)
	{
		int human = arr[i];
		int tmp = pq.top();
		pq.pop();
		if (human > tmp)
		{
			cout << 0 << "\n";
			return 0;
		}
		else
		{
			pq.push(tmp - human);
		}
	}
	cout << 1 << "\n";

	
	return 0;
}
