#include <iostream>
#include <vector>
using namespace std;

int N, N2;
int arr[101] = { 0 };

void func1(int b) {
	int tmp = b;
	while (b <= N)
	{
		if (arr[b] == 1) arr[b] = 0;
		else arr[b] = 1;
		b = b + tmp;
	}
	return;
}

void func2(int b) {
	if (arr[b] == 0) arr[b] = 1;
	else arr[b] = 0;
	int tmp = 1;
	while (b - tmp>=1 && b + tmp<=N)
	{
		if (arr[b - tmp] == arr[b + tmp]) {
			if (arr[b - tmp] == 0) {
				arr[b - tmp] = 1;
				arr[b + tmp] = 1;
			}
			else
			{
				arr[b - tmp] = 0;
				arr[b + tmp] = 0;
			}
			tmp += 1;
		}
		else break;
	}
	return;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		arr[i + 1] = num;
	}
	cin >> N2;
	for (int i = 0; i < N2; i++)
	{
		int a, b; cin >> a >> b;
		if (a == 1) func1(b);
		else func2(b);
	}

	for (int i = 1; i <= N; i++)
	{
		cout << arr[i] << " ";
		if (i % 20 == 0) cout << "\n";
	}

    return 0;
}
