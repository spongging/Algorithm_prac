#include <iostream>
#include <map>
using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	string s;
	map<string, int>m;
	int arr[1001];

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> s;
		m[s] = i;
	}

	int cnt = 0;

	for (int i = 0; i < N; i++)
	{
		cin >> s;
		arr[i] = m[s];
	}

	for (int i = 0; i < N; i++)
	{
		for (int j =i+1; j < N; j++)
		{
			if (arr[i] > arr[j])
			{
				cnt++;
				break;
			}
		}
	}

	cout << cnt << "\n";

	return 0;
}
