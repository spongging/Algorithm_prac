#include <iostream>
#include <string>
using namespace std;
int minf(string& a, string& b) {
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == '6')
        {
            a[i] = '5';
        }
    }
    for (int i = 0; i < b.length(); i++)
    {
        if (b[i] == '6')
        {
            b[i] = '5';
        }
    }
    int aa = stoi(a);
    int bb = stoi(b);
    return aa + bb;
}
int maxf(string& a, string& b) {
    for (int i = 0; i < a.length(); i++)
    {
        if (a[i] == '5')
        {
            a[i] = '6';
        }
    }
    for (int i = 0; i < b.length(); i++)
    {
        if (b[i] == '5')
        {
            b[i] = '6';
        }
    }
    int aa = stoi(a);
    int bb = stoi(b);
    return aa + bb;
}
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int a, b; cin >> a >> b;
    int min, max;
    string sa = to_string(a);
    string sb = to_string(b);
    min = minf(sa, sb);
    max = maxf(sa, sb);
    cout << min << " " << max << "\n";
    return 0;
}
