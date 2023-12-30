#include <iostream>
#include <vector>
using namespace std;
int main() {

    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    cout.tie(NULL);
    
    int N, K; cin >> N >> K;
    vector<int>v;

    int MAX = 0;

    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num); 
    }

    int st = 0, ed = 0, odd = 0, even = 0;
    
    while (ed < N)
    {
        if (v[ed] % 2 != 0)
        {
            odd++;
        }
        else
        {
            even++;
        }
        ed++;
        if (ed == N && st == 0)
        {
            MAX = even;
            break;
        }
        if (odd > K)
        {
            MAX = max(MAX, even);  
            if (v[st] % 2 != 0)
            {
                odd--;
            }
            else
            {
                even--;
            }
            st++;
        }
        

    }
    
    cout << MAX << "\n";
    return 0;
}
