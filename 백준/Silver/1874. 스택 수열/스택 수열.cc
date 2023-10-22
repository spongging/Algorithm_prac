#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int top; int last_push;
	vector<int>arr; stack<int>s; vector<int>arr2;
	vector<char>result;
	int n; cin >> n;

	for (int i = 0; i < n; i++)
	{
		int num; cin >> num;
		arr.push_back(num);
	}
	last_push = arr[0];
	for (int i = 1; i <= arr[0]; i++)
	{
		s.push(i); result.push_back('+');
		top = s.top();
	}
	arr2.push_back(top);
	s.pop(); result.push_back('-');
	int index = 1;
	while (index!=n)
	{
		if (top > arr[index])
		{
			top = s.top();
			arr2.push_back(top); 
			s.pop(); result.push_back('-');
			index++;
		}
		else if (top < arr[index])
		{
			for (int i = last_push+1; i <= arr[index]; i++)
			{
				s.push(i); result.push_back('+');
			}
			last_push = arr[index];
			arr2.push_back(last_push);
			top = s.top();
			s.pop(); result.push_back('-');
			index++;
		}
		else
		{
			index++;
		}
	}
	bool gkgk = equal(arr.begin(), arr.end(), arr2.begin(), arr2.end());
	
	if (gkgk==true)
	{
		for (int i = 0; i < result.size(); i++)
		{
			cout << result[i] << "\n";
		}
	}
	else cout << "NO" << "\n";
	return 0;
}