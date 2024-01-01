#include <iostream>
#include <vector>
using namespace std;
bool visited[100001] = { false };
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<int>v;
    int N; cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    int st = 0, ed = 0;
    long long cnt = 0;
    while (st < N) 
    {
        if (ed < N && !visited[v[ed]])
        {
            visited[v[ed]] = true;
            ed++;
            
        }
        else
        {
            visited[v[st]] = false; 
            cnt += ed - st;  
            st++;
        }
    }
    cout << cnt << "\n";
    return 0;
}
