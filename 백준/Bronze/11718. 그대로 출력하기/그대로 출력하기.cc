#include <iostream>
#include <string>
using namespace std;

int main(void) {
	while (1)
	{
		string A;
		getline(cin, A);
		if (cin.eof() == true)
		{
			break;
		}
		cout << A << endl;
	}
	return 0;
}