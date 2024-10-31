#include <iostream>
#include <stack>
using namespace std;
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 

    int N; cin >> N;
    stack<pair<int, int>>s;
    for (int i = 1; i <= N; i++)
    {
        int num; cin >> num;
        if (s.empty())
        {
            cout << 0 << " ";
            s.push({ i,num }); 
            continue;
        }
        while (!s.empty())
        {
            if (num > s.top().second)
            {
                s.pop();
            }
            else
            {
                cout << s.top().first << " ";
                s.push({ i,num });
                break; 
            }
        }
        if (s.empty())
        {
            cout << 0 << " ";
            s.push({ i,num });
        }
    }
   
    return 0;
}
