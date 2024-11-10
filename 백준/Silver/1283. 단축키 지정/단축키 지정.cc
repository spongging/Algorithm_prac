#include <iostream>
#include <string>
#include <vector>
using namespace std;
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
   
    int N; cin >> N;
    cin.ignore();
    string s; 
    bool alpha[26] = { false };
    while (N--)
    {
        getline(cin, s);
        string origin = s;
        for (int i = 0; i < s.length(); i++)
        {
            s[i] = tolower(s[i]);
        }
        if (s[0] != ' ' && !alpha[s[0] - 'a'])
        {
            cout << "[" << origin[0] << "]" << origin.substr(1, origin.length() - 1) << "\n";
            alpha[s[0] - 'a'] = 1;
            continue;
        }
        bool flag = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (s[i] != ' ' && s[i - 1] == ' ')
            {
                if (!alpha[s[i] - 'a'])
                {
                    cout << origin.substr(0, i) << "[" << origin[i] << "]" << origin.substr(i + 1, origin.length()-i - 1) << "\n";
                    alpha[s[i] - 'a'] = 1;
                    flag = 1;
                    break;
                }
            }
        }
        if (flag) continue;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i]!=' ' && !alpha[s[i]-'a'])
            {
                cout << origin.substr(0, i) << "[" << origin[i] << "]" << origin.substr(i + 1, origin.length()-i - 1) << "\n";
                alpha[s[i] - 'a'] = 1;
                flag = 1;
                break;
            }
        }
        if (!flag) {
            for (int i = 0; i < origin.length(); i++)
            {
                cout << origin[i];
            }
            cout << "\n";
        }

    }
    
    return 0;
}
