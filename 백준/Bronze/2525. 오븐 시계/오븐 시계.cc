#include <iostream>
using namespace std;

int main()
{
	int h, m;
	long m2;
	int aa, bb;
	cin >> h >> m;
	cin >> m2;

	if ((m + m2) <= 59)
	{
		cout << h <<" "<< m + m2;
	}
	else
	{
		aa = (m + m2) / 60;
		bb = (m + m2) % 60;
		h = h + aa;
		m = bb;
		if (h >= 24)
		{
			h = h % 24;
			cout << h << " " << m;
		}
		else
		{
			cout << h << " " << m;
		}
	}
	
}
