#include <iostream>
#include <vector>
#include <climits>
using namespace std;
vector<int>v;
int cnt = 0;
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    cout.tie(NULL);
    int N, K; cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        if (num==1)
        {
            v.push_back(i);
        }
    }
    int min = INT_MAX;
    int sum; int end; int st;
    if (v.size() < K)
    {
        cout << -1 << "\n";
        return 0;
    }
    for (int i = 0; i <= v.size() - K; i++)
    {
        st = i; end = i + K-1;
        sum = v[end] - v[st] + 1;
        if (sum < min)
        {
            min = sum;
        }
    }
    cout << min << "\n";
    return 0;
}
