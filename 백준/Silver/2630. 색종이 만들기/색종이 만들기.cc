#include <iostream>
using namespace std; 
int arr[128][128]; 
int N, white = 0, blue = 0; 
void func(int y, int x, int n) {
	
	int first_color = arr[y][x];

	for (int i = y; i < y + n; i++)
	{
		for (int j = x; j < x + n; j++)
		{
			if (first_color != arr[i][j])
			{
				func(y, x, n / 2);
				func(y, x + (n / 2), n / 2);
				func(y + (n / 2), x, n / 2);
				func(y + (n / 2), x + (n / 2), n / 2);
				return;
			}
		}
	}

	if (first_color == 1)
	{
		blue ++;
	}
	else white ++;


}
int main() {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);   
	
	cin >> N; 
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			int num; cin >> num;

			arr[i][j] = num; 
		}
	}
	int n = 0;
	func(0, 0, N);
	cout << white << "\n" << blue << "\n";

	return 0;
}