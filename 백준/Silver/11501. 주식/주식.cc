#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

int T, N;
int arr[1000001];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> N; 
		ll cnt = 0; 
		for (int j = 0; j < N; j++)
		{
			int num; cin >> num;  
			arr[j] = num;
		}

		int max = arr[N - 1];

		for (int j = N - 2; j >= 0; j--)
		{
			int num = arr[j];
			if (num <= max)
			{
				int tmp = max - num;
				cnt += tmp; 
			}
			else
			{
				max = num;
			}
		}
		cout << cnt << "\n";
	}
	
	
	return 0;

} 
