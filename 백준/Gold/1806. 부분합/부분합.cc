#include <iostream>
#include <vector>
#include <climits>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S; cin >> N >> S;
    vector<int>v;

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    int st = 0;
    int ed = 0;
    int len = 1;
    int result = 100000;
    int sum = v[st];
    bool TF = 0;
    while (true)
    {
        if (sum < S)
        {
            if (ed == N-1) break;
            ed++;
            sum += v[ed];
            len++;
            
        }

        else
        {
            TF = 1;
            result = min(result, len);
            sum -= v[st];
            st++;
            len--;

        }
    }
    if (TF) cout << result;
    else cout << 0;
    return 0;
}