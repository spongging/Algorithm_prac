#include <iostream>
#include <vector>
using namespace std;



int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	char arr[101][101];
	int arr2[101][101];
	int H, W; cin >> H >> W;
	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < W; j++)
		{
			char c; cin >> c;
			arr[i][j] = c;
		}
	}

	for (int i = 0; i < H; i++)
	{
		int cnt = 0;
		bool flag = false;
		for (int j = 0; j < W; j++)
		{
			char tmp = arr[i][j];
			if (tmp == 'c') {
				flag = 1;
				cnt = 0;
				arr2[i][j] = 0;
			}
			else
			{
				if (flag == 0) {
					arr2[i][j] = -1;
				}
				else {
					cnt += 1;
					arr2[i][j] = cnt;
				}
			}
		}
		flag = 0;
	}
	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < W; j++)
		{
			cout << arr2[i][j] << " ";
		}
		cout << "\n";
	}
    return 0;
}
