#include <iostream>
#include <queue>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 
	 
	int N; cin >> N;
	queue<int>q;
	if (N == 1)
	{
		cout << 1;
	}
	for (int i = 1; i <= N; i++)
	{
		q.push(i);
	}
	int top;
	while (!q.empty())
	{
		q.pop();
		top = q.front();
		if (q.size()==1)
		{
			cout << top<<"\n";
			break;
		}
		q.pop();
		q.push(top);

	}

	return 0;
}