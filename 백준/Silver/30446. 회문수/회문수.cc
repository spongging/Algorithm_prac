#include <iostream>
#include <string>
#include <set>
#include <algorithm>
using namespace std;
long long cnt = 0;
set<long long>nums; 
void find_palin_even(long long N) {

	for (long long i = 1; i <= 99999; i++)
	{
		string str = to_string(i);
		string s = str;
		reverse(str.begin(), str.end());
		string final_str = s + str; 
		long long num = stoll(final_str); 
		if (num <= N) { 
			nums.insert(num); 
		}
		else {
			break; 
		}
	}
	return;
}
void find_palin_odd(long long N) {
	for (long long i = 1; i <= 99999; i++)
	{
		string str = to_string(i);
		string str2 = str.substr(0, str.size() - 1);
		reverse(str2.begin(), str2.end());
		string final_str = str + str2;
		long long num = stoll(final_str); 
		if (num <= N) { 
			nums.insert(num); 
		}
		else {
			break; 
		}
	}
	return;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long N; cin >> N;
	string str = to_string(N);
	find_palin_even(N); find_palin_odd(N); 
	auto it = nums.upper_bound(N);  
	cnt = distance(nums.begin(), it); 

	cout << cnt << "\n"; 
	return 0;
}