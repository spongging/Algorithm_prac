#include <iostream>
#include <vector>
using namespace std;

bool func(double d) {
    if (d >= 0.129 && d <= 0.138) {
        return 1;
    }
    else return 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L; cin >> N >> L;
    vector<int>v;
    int result = 0;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    int sum = 0;
    int st = 0;
    int ed = st + L - 1;
    for (int i = 0; i < L; i++)
    {
        sum += v[i];
        if (func(sum*0.001)) {
            result++;
        }
    }
    if (N == L) {
        sum -= v[N - 1];
        cout << result << "\n";
        exit(0);
    }
    while (1) 
    {
        if (ed+1 == N) break;
        sum -= v[st];
        st++; ed++;
        sum += v[ed];
        if (func(sum*0.001)) result++; 
    }
    cout << result << "\n";
    return 0;
}
