#include <iostream>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s; cin >> s;
    int cnt2 = 0;
    int arr[10] = { 0 };
    for (int i = 0; i < s.length(); i++)
    {
        char c = s[i];
        if (c == '6' || c == '9') cnt2++;
        else
        {
            arr[c-'0'] = arr[c-'0'] + 1;
        }
    }
    int MAX = 0;
    for (int i = 0; i < 9; i++)
    {
        if (MAX < arr[i]) {
            MAX = arr[i];
        }
    }
    if (cnt2 % 2 != 0) {
        cnt2 += 1;
    }
    if (MAX > cnt2 / 2) {
        cout << MAX;
    }
    else cout << cnt2 / 2;

    return 0;
}
