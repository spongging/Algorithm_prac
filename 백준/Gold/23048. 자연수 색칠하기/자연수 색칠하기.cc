#include <iostream>
#include <vector>
using namespace std;

int arr[500001];
bool visited[500001] = { 0 };
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; 
	cin >> N; 
	int cnt = 1; arr[1] = 1; 
	for (int i = 2; i <= N; i++)
	{
		int j = 1;
		if (visited[i]) continue;
		visited[i] = 1; 
		cnt++;
		while (1)
		{
			int tmp = i * j;
			if (tmp > N) break;
			arr[tmp] = cnt; 
			visited[tmp] = 1;
			j++; 
		}
	}
	cout << cnt << "\n";
	for (int i = 1; i <= N; i++)
	{
		cout << arr[i] << " ";
	}

	return 0;
}