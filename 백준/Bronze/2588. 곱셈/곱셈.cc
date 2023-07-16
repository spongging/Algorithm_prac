#include <iostream>
using namespace std;
int main() 
{
	int a, b, c, d, e, f;
	cin >> a;
	cin >> b;
	c = b / 100;
	d = b / 10;
	e = b % d;
	f = d % (c * 10);
	cout << a * e << endl;
	cout << a * f << endl;
	cout << a * c << endl;
	cout << a * b;
}
