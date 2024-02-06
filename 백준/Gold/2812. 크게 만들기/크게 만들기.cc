#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int N, K;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> K;
	stack<int>s;
	stack<int>s1;
	string num; cin >> num; 


	for (int i = 0; i < num.size(); i++)
	{
		int tmp = num[i] - '0';
		while (!s.empty() && K > 0 && tmp > s.top())
		{
			s.pop();
			K--;  
		}
		s.push(tmp);
	}

	while (K > 0) {
		K--;
		s.pop();
	}
	while (!s.empty())
	{
		s1.push(s.top());
		s.pop();
	}
	while (!s1.empty()) 
	{
		cout << s1.top();
		s1.pop();
	}

	return 0;

} 
