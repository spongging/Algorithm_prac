#include <iostream>
using namespace std;

int arr[65][65];
int N;

void func(int size, int x, int y) {

	int init = arr[x][y]; 

	for (int i = x; i < x + size; i++)
	{
		for (int j = y; j < y + size; j++)
		{
			if (init != arr[i][j]) {
				cout << '(';
				func(size / 2, x, y);
				func(size / 2, x, y + size / 2);
				func(size / 2, x + size / 2, y);
				func(size / 2, x + size / 2, y + size / 2);
				cout << ')';
				return;
			}
		}
	}

	cout << init;

	return;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		string str; cin >> str;
		for (int j = 0; j < N; j++) { arr[i][j] = str[j] - '0'; }
	}


	func(N, 0, 0);

	return 0;
}