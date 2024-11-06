#include <iostream>
#include <vector>
using namespace std;
int N;
char arr[6][6]; 
vector<pair<int, int>>v;  
bool flag = 0;
bool search(int a, int b) {
    for (int i = a; i >= 0; i--) // up
    {
        if (arr[i][b] == 'O') break;
        if (arr[i][b]=='S')
        {
            return false;
        }
    }
    for (int i = a; i < N; i++) //down
    {
        if (arr[i][b] == 'O') break;
        if (arr[i][b] == 'S')
        {
            return false;
        }
    }
    for (int i = b; i >= 0; i--) //left
    {
        if (arr[a][i] == 'O') break;
        if (arr[a][i] == 'S')
        {
            return false;
        }
    }
    for (int i = b; i < N; i++) //right
    {
        if (arr[a][i] == 'O') break;
        if (arr[a][i] == 'S')
        {
            return false;
        }
    }
    return true;
}
void dfs(int a, int b, int depth) {
    if (flag) return;
    if (depth == 3)
    {
        for (int i = 0; i < v.size(); i++)
        {
            if (!search(v[i].first, v[i].second)) {
                return;
            }
        }
        flag = 1; 
        return;
    }
    for (int i = a; i < N; i++)
    {
        int start;
        if (i == a)
        {
            start = b;
        }
        else start = 0;
        for (int j = start; j < N; j++)
        {
            if (arr[i][j] == 'X') {
                arr[i][j] = 'O';
                dfs(i, j, depth + 1);
                arr[i][j] = 'X'; 
            }
        }
    }
}
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
   
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            char c; cin >> c;
            arr[i][j] = c;
            if (c == 'T')
            {
                v.push_back({ i,j }); 
            }
        }
    }
    dfs(0, 0, 0);
    if (flag) cout << "YES" << "\n";
    else cout << "NO" << "\n"; 
    return 0;
}
