#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

bool func(string a, string b) {
	if (a.length()==b.length())
	{
		return a < b;
	}
	return a.length() < b.length();
}

int main(void) {

	string A;
	vector<string>arr;
	set<string> checkSet;
	int N; cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> A;
		if (checkSet.find(A)==checkSet.end())
		{
			checkSet.insert(A);
			arr.push_back(A);
		}
	}
	
	sort(arr.begin(), arr.end(), func);

	for (int i = 0; i < arr.size(); i++)
	{
		cout << arr[i] << endl;
	}
	return 0;
}