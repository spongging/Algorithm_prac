#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N;
vector < pair<int, int>>v;
priority_queue<int, vector<int>, greater<int>>pq;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num1, num2; cin >> num1 >> num2;
        v.push_back(make_pair(num1, num2));
    }
    sort(v.begin(), v.end());
    pq.push(v[0].second);

    for (int i = 1; i < N; i++)
    {
        if (pq.top() > v[i].first)
        {
            pq.push(v[i].second);
        }
        else
        {
            pq.pop();
            pq.push(v[i].second);
        }
    }
    cout << pq.size() << "\n";
    return 0;
}