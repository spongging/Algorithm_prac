#include <iostream>
#include <vector>
#include <string>
#include <deque>
using namespace std;
int arr[11]; 
int N; 
bool cal(string s) {
    deque<int>num; 
    vector<char>op;
    string buffer = "";
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '+' || s[i] == '-') {
            op.push_back(s[i]); 
            num.push_back(stoi(buffer));
            buffer = "";
        }
        if (s[i] >= '1' && s[i] <= '9')
        {
            buffer += s[i];
        }
    }
    num.push_back(stoi(buffer));
    int result = 1;
    for (int i = 0; i < op.size(); i++)
    {
        if (op[i] == '+') {
            int a = num.front(); num.pop_front();
            int b = num.front(); num.pop_front();
            result = (a + b);
            num.push_front(result); 
        }
        else
        {
            int a = num.front(); num.pop_front();
            int b = num.front(); num.pop_front();
            result = (a - b);
            num.push_front(result);
        }
    }
    if (result == 0) return 1;
    else return 0; 
}

void dfs(int depth, string s) {
    s += to_string(arr[depth]);
    if (depth == N)
    {
        if (cal(s)) {
            for (int i = 0; i < s.length(); i++)
            {
                cout << s[i];
            }
            cout << "\n"; 
        }
        return;
    }
    dfs(depth + 1, s + " "); 
    dfs(depth + 1, s + "+");
    dfs(depth + 1, s + "-");
}

int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int T; cin >> T;
    for (int i = 0; i <= 10; i++) arr[i] = i;
    while (T--)
    {
        cin >> N;
        dfs(1, ""); 
        cout << "\n";
    }
     
    return 0;
}
