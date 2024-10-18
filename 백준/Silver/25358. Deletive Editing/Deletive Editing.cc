#include <iostream>
#include <vector>
using namespace std;

int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int n; cin >> n;
    while (n--)
    {
        vector<bool>TF(26, false);
        vector<int>scnt(26, 0);  
        vector<int>targetcnt(26, 0);  
        string s; cin >> s;
        string target; cin >> target;
        int idx = 0; 
        vector<char>sv;
        for (int i = 0; i < s.length(); i++) {
            sv.push_back(s[i]);
            scnt[s[i] - 'A']++; 
        }
        for (int i = 0; i < target.length(); i++)
        {
            TF[target[i] - 'A'] = 1; 
            targetcnt[target[i] - 'A']++; 
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (TF[s[i] - 'A'])
            {
                if (scnt[s[i] - 'A'] != targetcnt[s[i] - 'A'])
                {
                    sv.erase(sv.begin() + idx);
                    scnt[s[i] - 'A']--;
                }
                else idx++; 
            }
            else
            {
                sv.erase(sv.begin() + idx);  
            }
        }
        if (sv.size()!=target.length())
        {
            cout << "NO" << "\n";
        }
        else
        {
            for (int i = 0; i < sv.size(); i++)
            {
                if (sv[i]!=target[i])
                {
                    cout << "NO" << "\n";
                    break;
                }
                if (i==sv.size()-1)
                {
                    cout << "YES" << "\n"; 
                }
            }
        }
    }

    return 0;

}
