#include <iostream>
using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int dx[31];
	int dy[31];
	int D, K; cin >> D >> K;
	dx[0] = 0; dx[1] = 1; dx[2] = 0;
	dy[0] = 0; dy[1] = 0; dy[2] = 1;
	for (int i = 3; i <= D; i++)
	{
		dx[i] = dx[i - 1] + dx[i - 2];
		dy[i] = dy[i - 1] + dy[i - 2];
	}
	int x = 1; int y;
	while (1)
	{
		if ((K - dx[D] * x) % dy[D] == 0) {
			y = (K - dx[D] * x) / dy[D];
			cout << x << "\n" << y << "\n";
			break;
;		}
		x++;
	}

	return 0;
}