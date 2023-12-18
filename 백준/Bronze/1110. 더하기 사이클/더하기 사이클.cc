#include <iostream>
#include <string>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int N; cin >> N; int init = N;
    int cnt = 0;
    while (1)
    {
        init = (init % 10 * 10) + (init / 10 + init % 10) % 10;
        cnt++;
        if (init == N)
        {
            break;
        }

    }
    cout << cnt << "\n";
    return 0;
}
