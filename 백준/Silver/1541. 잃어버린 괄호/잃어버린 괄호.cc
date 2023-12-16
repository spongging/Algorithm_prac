#include <iostream>
#include <vector>
#include <string>
using namespace std;
vector<int>v;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    string str; cin >> str; 
    bool a = false;
    string s = "";
    int result = 0;
    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] >= '0' && str[i] <= '9')
        {
            s += str[i];
        }
        else
        {
            if (!a)
            {
                result += stoi(s);
                s = "";
            }
            else
            {
                result -= stoi(s);
                s = "";
            }
            if (str[i]=='-')
            {
                a = true;
            }
        }
        if (i == str.length() - 1)
        {
            if (!a)
            {
                result += stoi(s);
                s = "";
            }
            else
            {
                result -= stoi(s);
                s = "";
            }
        }
    }
    cout << result << "\n";
    return 0;
}
