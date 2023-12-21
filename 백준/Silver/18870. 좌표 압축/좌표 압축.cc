#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    vector<int>v;
    vector<int>v2;
    vector<int>v3;
    int N; cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    v2 = v; 
    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());
    int init;
    for (int i = 0; i < N; i++)
    {
        init = v2[i];
        auto it = lower_bound(v.begin(), v.end(), init);
        v3.push_back(it-v.begin());
    }
    for (int i = 0; i < N; i++)
    {
        cout << v3[i] << " ";
    }
    cout << "\n";
    return 0;
}
