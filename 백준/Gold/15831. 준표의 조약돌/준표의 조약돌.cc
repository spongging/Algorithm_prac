#include <iostream>
#include <vector>
#include <map>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, B, W; cin >> N >> B >> W;
    string s; cin >> s; 
    map<char, int>m;
    m['W'] = 0;
    m['B'] = 0;
    int st = 0; int ed = 0;
    int result = 1;
    int len = 0;
    m[s[st]] += 1;
    if (m['W'] >= W && m['B'] <= B) {
        len = max(result, len);
    }
    while (ed + 1 < N) 
    {
        if (s[ed+1] == 'B')
        {
            if (m['B'] < B)
            {
                ed++; 
                m[s[ed]] += 1;
                result++; 
                if (m['W'] >= W) {
                    len = max(result, len); 
                }
            }
            else
            {
                m[s[st]] -= 1;
                st++; 
                result--; 
            }
        }
        else
        {
            ed++; 
            m[s[ed]] += 1;
            result++;
            if (m['W'] >= W) {
                len = max(result, len);
            }
        }
    }
    cout << len << "\n";
    return 0;
}
