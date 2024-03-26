#include <iostream>
using namespace std;

int N, K;
int cnt = 0;


int partition(int arr[], int p, int r) {
    int x = arr[r];
    int i = p - 1;
    for (int j = p; j < r; j++)
    {
        if (arr[j] <= x) {
            i++;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
            cnt++; 
            if (cnt == K)
            {
                cout << arr[i] << " " << arr[j] << "\n";
                return -1;
            }
        }
    }
    if (i + 1 != r) {
        int tmp = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = tmp; 
        cnt++;
        if (cnt == K)
        {
            cout << arr[i+1] << " " << arr[r] << "\n";
            return -1;
        }
    }
    return i + 1;
}
void quick_sort(int arr[], int p, int r) {
    if (p < r) {
        int q = partition(arr, p, r);
        if (q == -1) {
            return;
        }
        quick_sort(arr, p, q-1);
        quick_sort(arr, q + 1, r);
    }
}


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    int* arr = new int[N];

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        arr[i] = num;
    }
    quick_sort(arr, 0, N - 1);
    if (cnt < K) cout << -1;
   
    return 0;
}
