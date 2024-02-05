#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
int arr[1001];
ll sum[1001];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N; cin >> N;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		arr[i] = num; 
	}
	sort(arr, arr + N);
	sum[0] = arr[0];
	for (int i = 1; i < N; i++)
	{
		sum[i] = sum[i-1] + arr[i];
	}
	ll result = 0;
	for (int i = 0; i < N; i++)
	{
		result += sum[i];
	}
	cout << result << "\n";
	return 0;

}
