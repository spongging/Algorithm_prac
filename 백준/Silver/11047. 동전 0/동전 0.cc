#include <iostream>
#include <vector>
using namespace std;
vector<int>v;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int n, k;
    cin >> n >> k;
    int result = 0;
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        v.push_back(a);
    }
    for (int i = n - 1; i >= 0; i--)
    {
        int div = k / v[i];
        if (div != 0)
        {
            result += div;
            k = k % (div * v[i]);
        }
    }
    cout << result << "\n";
    return 0;
}
