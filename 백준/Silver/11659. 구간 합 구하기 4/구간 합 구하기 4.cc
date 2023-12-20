#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int N, M; cin >> N >> M;
    vector<int>v;
    vector<int>sum;
    sum.resize(N); 
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    sum[0] = v[0];
    for (int i = 1; i < N; i++)
    {
        sum[i] = sum[i - 1] + v[i];
    }
    for (int i = 0; i < M; i++)
    {
        int start, last; cin >> start >> last; 
        int result;
        if (start==1)
        {
            result = sum[last - 1];
        }
        else
        {
            result = sum[last - 1] - sum[start - 1 - 1];
        }
        cout << result << "\n";
    }
    return 0;
}
