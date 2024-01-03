#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T; cin >> T;
    for (int i = 0; i < T; i++)
    {
        int N, M;  
        long long K; 
        cin >> N >> M >> K;
        vector<int>v;
        for (int i = 0; i < N; i++)
        {
            int num; cin >> num;
            v.push_back(num);
        }
        ll hap = 0;
        if (N == M)
        {
            for (int i = 0; i < N; i++)
            {
                hap += v[i];
            }
            if (hap < K)
            {
                cout << 1 << "\n";
            }
            else
            {
                cout << 0 << "\n";
            }
            hap = 0;
        }
        else
        {
            int st = 0, ed = st + M - 1; int cnt = 0;
            for (int i = 0; i < M; i++)
            {
                hap += v[i];
            }
            while (st < N)
            {
                if (hap < K)
                {
                    cnt++;
                }
                ed++;
                if (ed == N)
                {
                    ed = 0;
                }
                hap = hap - v[st] + v[ed];
                st++;
            }
            cout << cnt << "\n";
            cnt = 0, hap = 0;
        }
    }
    
    
    
    return 0;
}
