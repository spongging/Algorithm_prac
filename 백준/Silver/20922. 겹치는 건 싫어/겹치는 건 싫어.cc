#include <iostream>
#include <vector>
#include <map>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K; cin >> N >> K;
    int result = 1;
    int tmp = 0;
    vector<int>v;
    map<int, int>m;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
        m[num] = 0;
    }
    int st = 0;
    int ed = 0;
    m[v[ed]] += 1;
    while (ed + 1 < N)
    {
        if (m[v[ed + 1]] != K) {
            ed++;
            m[v[ed]] += 1;
            result++;
            tmp = max(result, tmp);
        }
        else
        {
            result--;
            m[v[st]] -= 1;
            st++;
        }
    }
    cout << tmp << "\n"; 

    return 0;
}
