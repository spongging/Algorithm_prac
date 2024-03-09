#include <iostream>
#include <set>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s1, s2, s3, name;
	set<string>s;
	int cnt = 0;
	cin >> s1 >> s2 >> s3;
	int start = stoi(s1.substr(0, 2)) * 60 + stoi(s1.substr(3, 2));
	int end = stoi(s2.substr(0, 2)) * 60 + stoi(s2.substr(3, 2));
	int end2 = stoi(s3.substr(0, 2)) * 60 + stoi(s3.substr(3, 2));

	while (cin >> s1 >> name)
	{
		int tmp = stoi(s1.substr(0, 2)) * 60 + stoi(s1.substr(3, 2));
		if (start >= tmp)
		{
			s.insert(name);
		}
		if (end <= tmp && tmp <= end2)
		{
			if (s.find(name) != s.end())
			{
				cnt++;
				s.erase(name);
			}
		}
		
	}

	cout << cnt << "\n";

	return 0;
}
