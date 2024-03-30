#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    int N, M;
    vector<int>v;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    cin >> M;

    sort(v.begin(), v.end());
    int st = 0;
    int ed = v[N - 1];
    int result;
    while (st <= ed)
    {
        int sum = 0;
        int mid = (st + ed) / 2;
        for (int i = 0; i < N; i++)
        {
            sum += min(v[i], mid);
        }
        if (sum <= M) {
            result = mid;
            st = mid+1;
        }
        else
        {
            ed = mid - 1;
        }
    }

    cout << result << "\n";

    return 0;
}
