#include <iostream>
#include <vector>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    vector<int>v;
    int G; cin >> G;
    int p = 1, m = 1;

    while (p <= 100000)
    {
        int sub = p * p - m * m;
        if (sub == G)
        {
            v.push_back(p);
            p++;
        }
        else if (sub < G)
        {
            p++;
        }
        else
        {
            m++;
        }
    }
    if (v.empty())
    {
        cout << -1 << "\n";
    }
    else
    {
        for (int a : v) {
            cout << a << "\n";
        }
    }

    return 0;
}
