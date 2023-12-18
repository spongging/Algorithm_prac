#include <iostream>
#include <string>
using namespace std;
int arr[1001][1001]; 
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL); 
    int N, M; cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        arr[0][i] = num;
    }
    for (int i = N; i < N+M; i++)
    {
        arr[0][i] = 0;
    }
    for (int i = 0; i < N; i++)
    {
        int cnt = 0;
        for (int j = 0; j < N + M; j++)
        {
            int aa; cin >> aa;
            cnt += aa;
            arr[0][j] += aa;
        }
        arr[0][i] -= cnt;
    }
    for (int i = 0; i < N+M; i++)
    {
        cout << arr[0][i] << " ";
    }
    cout << "\n";
    return 0;
}
