#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int arr[100001][3];  

int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int currmax[3], currmin[3], prevmin[3], prevmax[3];
    int N; cin >> N; 
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            int num; cin >> num;
            arr[i][j] = num; 
        }
    }
    
    prevmax[0] = arr[0][0];
    prevmax[1] = arr[0][1];
    prevmax[2] = arr[0][2];
    
    prevmin[0] = arr[0][0];
    prevmin[1] = arr[0][1];
    prevmin[2] = arr[0][2];
    
    for (int i = 1; i < N; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (j == 0)
            {
                currmax[j] = arr[i][j] + max(prevmax[0], prevmax[1]);
                currmin[j] = arr[i][j] + min(prevmin[0], prevmin[1]);
            }
            else if (j == 2) {
                currmax[j] = arr[i][j] + max(prevmax[2], prevmax[1]);
                currmin[j] = arr[i][j] + min(prevmin[2], prevmin[1]);
            }
            else
            {
                currmax[j] = arr[i][j] + max({ prevmax[0], prevmax[1],prevmax[2] });
                currmin[j] = arr[i][j] + min({ prevmin[0], prevmin[1],prevmin[2] });
            }
        }
        for (int i = 0; i < 3; i++)
        {
            prevmax[i] = currmax[i];
            prevmin[i] = currmin[i];
        }
    }
    cout << max({ prevmax[0],prevmax[1],prevmax[2] }) << " " << min({ prevmin[0],prevmin[1],prevmin[2] });
    return 0;
}
