#include <iostream>
using namespace std;

int main()
{
	int h, m;
	cin >> h >> m;
	if (m >= 45)
	{
		cout << h << " " << m - 45;
	}
	else
	{
		if (h == 0)
		{
			m = m - 45;
			m = 60 + m;
			cout << 23 << " " << m;
		}
		else
		{
			h = h - 1;
			m = m - 45;
			m = 60 + m;
			cout << h << " " << m;
		}
	}
}


