#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    int N, C; cin >> N >> C;
    vector<int>v;
    int result = 0;

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int st = 1;
    int ed = v[N - 1] - v[0];
    while (st <= ed)
    {
        int tmp = v[0];
        int cnt = 1;
        int mid = (st + ed) / 2;

        for (int i = 1; i < N; i++)
        {
            if (v[i] - tmp >= mid) {
                cnt++;
                tmp = v[i];
            }
        }
        if (cnt < C)
        {
            ed = mid - 1;
        }
        else
        {
            result = max(result, mid);
            st = mid + 1;
        }
    }
    cout << result << "\n";
    return 0;
}
