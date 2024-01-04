#include <iostream>
#include <vector>
#include <climits>
using namespace std;
int n, k; int arr[10001];
bool func(vector<int>& v) {

    for (int i = 1; i <= k; i++)
    {
        if (v[i] == 0)
        {
            return false;
        }
    }
    return true;
}
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    bool TF = false;
    int result = INT_MAX;
    vector<int>p(n + 1, 0);
    vector<int>tmp(n + 1, 0);
    for (int i = 0; i < n; i++)
    {
        int num; cin >> num;
        arr[i] = num;
        p[num] += 1;
    }
    int ed = 0;
    int st = 0;
    while (st < n)
    {
        TF = false;
        while (ed < n)
        {
            p[arr[ed]] -= 1;
            tmp[arr[ed]] += 1;
            if (func(tmp))
            {
                TF = true; 
                if (func(p)) // func(p) = true, p' 생성
                {
                    result = min(result, ed - st + 1); 
                }
                if (TF) // ed중복 ㄴㄴ 방지
                {
                    p[arr[ed]] += 1;
                    tmp[arr[ed]] -= 1;
                    break;
                }
            }
            else // 다 못채웟으면
            {
                ed++;
            }
        }
        p[arr[st]] += 1;
        tmp[arr[st]] -= 1; 
        st++;
       
    }
    if (result == INT_MAX)
    {
        cout << 0 << "\n";
    }
    else cout << result << "\n";

    return 0;
}
