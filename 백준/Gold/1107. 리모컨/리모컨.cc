#include <iostream>
#include <vector>
#include <cmath>
#include <string>
using namespace std;

vector<bool>mal(10, false);
bool check1(int num) {
	string str = to_string(num);
	for (int i = 0; i < str.length(); i++)
	{
		if (mal[str[i] - 48])
		{
			return false;
		}
	}
	return true;
}
int main() {
	 
	ios_base::sync_with_stdio(false);   
	cin.tie(NULL); 
	cout.tie(NULL);
	
	int len; int N, M;
	cin >> N; cin >> M;
	int tmp;
	for (int i = 0; i < M; i++)
	{
		int num; cin >> num;
		mal[num] = true; 
	}
	int aa = abs(100 - N);
	int min2;
	for (int i = 0; i <= 1000000; i++)
	{
		if (check1(i))
		{
			tmp = abs(N - i) + to_string(i).length();
			aa = min(aa, tmp); 
		}
	
	}
	cout << aa << "\n";

	return 0;
}