#include <iostream>
#include <vector>
using namespace std;
vector<int>v;
int cnt = 0;
int MAX = 0;
int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    cout.tie(NULL); 
    int N, X; cin >> N >> X;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    int sum = 0;
    for (int i = 0; i < X; i++)
    {
        sum += v[i];
        if (sum > MAX)
        {
            MAX = sum;
        }
    }
    int init = sum;
    for (int i = 1; i <= N - X - 1; i++)
    {
        sum = sum - v[i - 1] + v[i + X - 1];
        if (sum > MAX)
        {
            MAX = sum;
        }
    }
    sum = init;
    if (init == MAX)
    {
        cnt++;
    }
    for (int i = 1; i <= N - X; i++)
    {
        sum = sum - v[i - 1] + v[i + X - 1];
        if (sum == MAX)
        {
            cnt++;
        }
    }

    if (MAX==0)
    {
        cout << "SAD" << "\n";
    }
    else
    {
        cout << MAX << "\n";
        cout << cnt << "\n";
    }
    return 0;
}
