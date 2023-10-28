#include <iostream>
#include <vector>
using namespace std;
vector<long long>dp = { 0,1,2 };
int main() {

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL);  
	cout.tie(NULL) ; 
	
	int N; cin >> N;
	for (int i = 3; i <= N; i++)
	{
		int num;
		 num = dp[i - 2] + dp[i - 1];
		 dp.push_back(num % 15746);
	}
	cout << dp[N] << "\n";



	return 0;
}