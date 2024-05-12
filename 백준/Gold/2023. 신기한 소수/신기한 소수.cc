#include <iostream>
#include <string>
using namespace std;

int N;

bool judge(int tmp) {
	for (int i = 2; i * i <= tmp; i++)
	{
		if (tmp % i == 0) {
			return false;
		}
	}
	return true;
}

void func(string num) {
	if (num.length() == N) {
		if(num[0]!='1') cout << num << "\n";
		return;
	}
	for (int i = 1; i <= 9; i++)
	{
		string tmpnum = num;
		char c = i + '0';
		int tmp = stoi(tmpnum + c);
		if (judge(tmp)) func(num + c);
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	func("");

	return 0;
	
}

