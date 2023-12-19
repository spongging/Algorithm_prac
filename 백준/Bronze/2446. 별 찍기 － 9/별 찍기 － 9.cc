#include <iostream>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int N; cin >> N;
    int i = 1; int tmp = N;
    int tmp3 = N;
    int z = 1;
    int p = N;
    while (i <= (2 * N) - 1)
    {
        int tmp2 = tmp * 2 - 1;
        for (int y = 0; y < abs(N-tmp3); y++)
        {
            cout << " ";
        }
        if (p>1)
        {
            tmp3--;
            if (tmp3 == 0)
            {
                tmp3++;
            }
        }
        else
        {
            tmp3++;
           
        }
        p--;
        for (int j = 1; j <= tmp2; j++)
        {
            cout << "*";
        }
        cout << "\n";
        if (z < N)
        {
            tmp--;
        }
        else
        {
            tmp++;
        }
        z++;
        i++;
    }
    return 0;
}
