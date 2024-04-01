#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N; cin >> N;
    int dir = 1;
    vector<char>v;
    vector<pair<int, int>>p; 
    char arr[101][101];
    for (int i = 0; i < N; i++)
    {
        char c; cin >> c;
        v.push_back(c);
    }
    for (int i = 0; i < 101; i++)
    {
        for (int j = 0; j < 101; j++)
        {
            arr[i][j] = '#';
        }
    }
    p.push_back(make_pair(0, 0));
    int f = 0; int s = 0;
    for (int i = 0; i < N; i++)
    {
        char tmp_char = v[i];
        if (tmp_char == 'R')
        {
            dir++;
            if (dir > 4) {
                dir = 1;
            }
        }
        else if (tmp_char == 'L') {
            dir--;
            if (dir < 1) {
                dir = 4;
            }
        }
        else
        {
            if (dir == 1) {
                f++;
                p.push_back(make_pair(f, s));
            }
            else if (dir == 2) {
                s--;
                p.push_back(make_pair(f, s));
            }
            else if (dir == 3) {
                f--;
                p.push_back(make_pair(f, s));
            }
            else
            {
                s++;
                p.push_back(make_pair(f, s));
            }
        }
    }
    
    int min_dirf = INT_MAX;
    int min_dirs = INT_MAX;

    for (int i = 0; i < p.size(); i++)
    {
        min_dirf = min(min_dirf, p[i].first);
        min_dirs = min(min_dirs, p[i].second);
    }

    for (int i = 0; i < p.size(); i++)
    {
        p[i].first += abs(min_dirf);
        p[i].second += abs(min_dirs);
    }

    for (int i = 0; i < p.size(); i++)
    {
        arr[p[i].first][p[i].second] = '.';
    }

    int maxf = 0; int maxs = 0;

    for (int i = 0; i < p.size(); i++)
    {
        maxf = max(maxf, p[i].first);
        maxs = max(maxs, p[i].second);
    }

    int ppp = max(maxf, maxs); 

    for (int i = 0; i <=maxf; i++)
    {
        for (int j = 0; j <= maxs; j++)
        {
            if (arr[i][j] != '.') {
                cout << '#';
            }
            else cout << '.';
        }
        cout << "\n";
    }

    return 0;

}
