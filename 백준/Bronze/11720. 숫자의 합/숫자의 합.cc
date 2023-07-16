#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int main(void)
{
	int n;	
	int i;
	int hap = 0;
	string s;
	cin >> n;
	cin >> s;
	for (i = 0; i < n; i++)
	{
		hap += s[i] - '0';
	}
	cout << hap;
}
