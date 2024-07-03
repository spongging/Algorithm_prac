#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool TF[100001] = {0};
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    vector<int>v;
    int sum = 0;
    int result = 0;
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
        TF[num] = 1;
    }
    for (int i = 0; i < N; i++)
    {
        int tmp = M - v[i];
        if (tmp >= 0 && tmp <= 100000) {
            if (TF[tmp]) result++;
        }
    }
    cout << result / 2 << "\n";
    
    return 0;
}
