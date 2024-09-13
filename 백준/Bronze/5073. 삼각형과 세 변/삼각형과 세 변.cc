#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	int a, b, c;
	while (cin >> a >> b >> c)
	{
		if (a == 0 && b == 0 && c == 0) {
			break;
		}
		vector<int>v;
		v.push_back(a);
		v.push_back(b);
		v.push_back(c);
		sort(v.begin(), v.end()); 
		if (v[2] >= v[0] + v[1]) {
			cout << "Invalid" << "\n";
			continue;
		}
		else
		{
			if (v[0] == v[1] && v[1] == v[2]) {
				cout << "Equilateral" << "\n";
				continue;
			}
			else if (v[0] != v[1] && v[1] != v[2] && v[2] && v[0])
			{
				cout << "Scalene" << "\n";
				continue;
			}
			else
			{
				cout << "Isosceles" << "\n";
				continue;
			}
			
		}
	}

	return 0;
}