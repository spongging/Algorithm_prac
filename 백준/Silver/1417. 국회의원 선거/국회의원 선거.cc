#include <iostream>
#include <queue>
using namespace std;

int N;
priority_queue<int>pq;
int MAX = 0;
int start;
int cnt = 0;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        if (i == 0) {
            start = num;
        }
        else
        {
            pq.push(num);
        }
    }
    if (N == 1) {
        cout << 0 << "\n";
        return 0;
    }
    while (1)
    {
        if (start > pq.top()) break;
        if (start <= pq.top()) {
            start++;
            cnt++;
            int tmp = pq.top();
            pq.pop();
            tmp--; pq.push(tmp);
        }
    }
    cout << cnt << "\n";
    return 0;
}