#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, L, start, end;
    scanf("%d %d", &N, &L);
    vector<pair<int,int>> v;

    for (int i = 0; i < N; ++i) {
        scanf("%d %d", &start, &end);
        v.push_back(pair<int,int>(start, end));
    }

    sort(v.begin(), v.end());

    int count{0};
    int upcnt{0};
    for (int i = 0 ; i < v.size(); i++) {
        if(v[i].first > upcnt)
            upcnt = v[i].first;

        while(upcnt < v[i].second) {
            upcnt += L;
            count++;
        }
    }
    printf("%d", count);
}