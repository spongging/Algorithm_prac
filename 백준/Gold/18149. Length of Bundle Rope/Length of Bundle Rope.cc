#include <iostream>
#include <queue>
using namespace std;
int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int T; cin >> T;
    while (T--)
    {
        priority_queue<int, vector<int>, greater<int>>pq; 
        int n; cin >> n;  
        int result = 0; 
        for (int i = 0; i < n; i++)
        {
            int num; cin >> num;
            pq.push(num); 
        }
        while (pq.size() != 1)
        {
            int tmp1 = pq.top(); pq.pop();
            int tmp2 = pq.top(); pq.pop();
            result += (tmp1 + tmp2); 
            pq.push(tmp1 + tmp2);
        }
        cout << result << "\n"; 
    }
    return 0;
}
