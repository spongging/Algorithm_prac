#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

void func(int diff) {
	int share; int arr[7] = { 1,2,5,10,20,50,100 }; int total = 0;
	unordered_map<int, int> weigh;
	weigh[1] = 0; weigh[2] = 0; weigh[5] = 0; weigh[10] = 0;
	weigh[20] = 0; weigh[50] = 0; weigh[100] = 0;
	
	for (int i = 6; i >= 0; i--)
	{
		share = diff / arr[i];
		weigh[arr[i]] = share;
		diff -= share * arr[i];
	}
	for (const auto& pair : weigh) {
		total += pair.second;
	}
	cout << total << endl;
	return ;
}

int main(void) {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	vector<int>rock;
	int left = 0; int right = 0;
	int n; cin >> n;
	for (int i = 0; i < n; i++)
	{
		int num; cin >> num;
		rock.push_back(num);
	}
	left += rock[0];
	for (int i = 1; i < n; i++)
	{
		if (right < left) right += rock[i];
		else left += rock[i];
	}
	int differ = abs(left - right); func(differ);
	return 0;
}