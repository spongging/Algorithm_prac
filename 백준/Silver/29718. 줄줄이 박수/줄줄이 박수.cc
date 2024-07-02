#include <iostream>
#include <vector>
using namespace std;

int arr[2001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M; cin >> N >> M;
    for (int i = 0; i < 2001; i++) arr[i] = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            int num; cin >> num;
            arr[j] += num; 
        }
    }
    int A; cin >> A;
    int st = 0; int ed = st + A - 1;
    int sum = 0;
    int result = 0;
    for (int i = 0; i < A; i++)
    {
        sum += arr[i];
        result = max(result, sum); 
    }
    if (M == A) {
        cout << result << "\n";
        exit(0);
    }

    while (ed + 1 != M)
    {
        sum -= arr[st];
        st++; ed++;
        sum += arr[ed];
        result = max(result, sum);
    }
    cout << result << "\n";
    return 0;
}
