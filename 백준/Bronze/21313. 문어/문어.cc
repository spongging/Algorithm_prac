#include <iostream>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int N; cin >> N;
    int j = 1;
    int z = 1;
    if (N % 2 == 0)
    {
        while (z <= N)
        {
            cout << j << " ";
            j++; z++;
            if (j == 3)
            {
                j = 1;
            }
          
        }
    }
    else
    {
        while (z <= N - 1)
        {
            cout << j << " ";
            j++; z++;
          
            if (j==3)
            {
                j = 1;
            }

        }
        cout << "3";
    }
    cout << "\n";
    return 0;
}
