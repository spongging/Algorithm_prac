#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

#define fast ios_base::sync_with_stdio(false); cin.tie(0), cout.tie(0)
#define ll long long

const int MOD = 1000000000;

int N;
vector<ll> dp(1000001, 0);
vector<ll> nums;

int main() {
	fast;
    cin >> N;
    for (int i = 1; i <= N; i <<= 1) nums.push_back(i);
    dp[0] = 1;
    for (int i = 0; i < nums.size(); i++) {
        for (int j = nums[i]; j <= N; j++) {
            dp[j] = (dp[j] + dp[j - nums[i]]) % MOD;
        }
    }
    cout << dp[N];
    return 0;
}