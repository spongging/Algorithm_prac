#include <iostream>
#include <vector>
using namespace std;
vector<int>v;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int n; cin >> n;
    for (int i = 0; i < n; i++)
    {
        int cnt = 0;
        string str;
        cin >> str;
        for (int j = 0; j < 3; j++)
        {
            char c = str[j];
            if (c >= '0' && c <= '9')
            {
                int cc = c - '0';
                cnt += cc;
            }
        }
        cout << cnt << "\n";
    }
    return 0;
}
