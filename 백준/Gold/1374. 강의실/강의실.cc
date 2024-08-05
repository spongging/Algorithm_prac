#include <iostream>
#include <queue>
using namespace std;
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int N; cin >> N;
	int cnt = 0;
	int result = 0; 
	priority_queue<int, vector<int>, greater<int>>s;
	priority_queue<int, vector<int>, greater<int>>e;
	for (int i = 0; i < N; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		s.push(b);
		e.push(c); 
	}
	while (!s.empty())
	{
		if (s.top() < e.top()) {
			s.pop();
			cnt++;
			result = max(result, cnt);  
		}
		else
		{
			e.pop();
			cnt--;
		}
		
	}
	cout << result << "\n";
	return 0;
}