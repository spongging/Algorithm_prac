#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;
typedef long long ll;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    vector<ll>v;
    ll result = LLONG_MAX;
    for (int i = 0; i < N; i++)
    {
        ll num; cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int st = 0; int ed = v.size() - 1;
    int result_left, result_right;
    while (st != ed)
    {
        ll sum = v[st] + v[ed];
        if (abs(sum) < result)
        {
            result = abs(sum);
            result_left = v[st];
            result_right = v[ed];
        }
        if (sum > 0)
        {
            ed--;
        }
        else
        {
            st++;
        }

    }
    cout << result_left << " " << result_right << "\n";
    return 0;
}
