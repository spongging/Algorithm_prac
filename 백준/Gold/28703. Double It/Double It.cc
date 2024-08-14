#include <iostream>	
#include <queue>
#include <climits>
using namespace std;
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<int>q; //내
	priority_queue<int, vector<int>, greater<int>>q2;
	int N; cin >> N;
	int m = 0; int result = INT_MAX;  
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		m = max(m, num); 
		q.push(num); q2.push(num);
	}
	while (!q2.empty())
	{
		int q2top = q2.top();
		int tmp = q.top() - q2.top();
		q2.pop();
		result = min(result, tmp);
		if (q2top * 2 < m) q2.push(q2top * 2);
		else q.push(q2top * 2);
	}
	cout << result << "\n";
	return 0;
}