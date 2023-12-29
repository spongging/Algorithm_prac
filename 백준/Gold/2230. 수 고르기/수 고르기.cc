#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;
int arr[100001];
int main() {
   
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    cout.tie(NULL);
    
    int N, M; cin >> N >> M; 
    int mindiff = INT_MAX;  

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        arr[i] = num;
    }
    sort(arr, arr + N);
    
    int st = 0, ed = 0;

    while (st < N && ed < N)
    {
        int diff = arr[ed] - arr[st];
        if (diff >= M)
        {
            mindiff = min(diff, mindiff);
            st++; 
        }
        else
        {
            ed++;   
        }
    }
    cout << mindiff << "\n";

    return 0;
}
