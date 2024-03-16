#include <iostream>
#include <set>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    set<string>ss;

    for (int i = 0; i < s.length(); i++)
    {
        string tmp = "";
        tmp += s[i];
        ss.insert(tmp);
        for (int j = i + 1; j < s.length(); j++)
        {
            tmp += s[j];
            ss.insert(tmp); 
        }
    }

    cout << ss.size() << "\n";


    return 0;
}