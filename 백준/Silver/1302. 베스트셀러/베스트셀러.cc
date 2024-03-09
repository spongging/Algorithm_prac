#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int N;
map<string, int>m;
int result = 0;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	string s;
	for (int i = 0; i < N; i++)
	{
		cin >> s;
		m[s]++;
	}

	for (auto i = m.begin(); i != m.end(); i++)
	{
		result = max(result, i->second); 
	}

	for (auto i = m.begin(); i != m.end(); i++)
	{
		if (result == i->second)
		{
			cout << i->first << "\n";
			return 0;
		}
	}

	return 0;
}        