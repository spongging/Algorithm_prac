#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int N, M;
vector<int> v;
vector<int> tmp;

void dfs(int idx, int level, int last) {
    if (level == M) {
        for (int i = 0; i < tmp.size(); i++) {
            cout << tmp[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = idx; i < v.size(); i++) {
        if (v[i] >= last) {
            tmp.push_back(v[i]);
            dfs(i, level + 1, v[i]);
            tmp.pop_back();
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    set<int> uniqueNumbers;

    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        uniqueNumbers.insert(num);
    }

    v.assign(uniqueNumbers.begin(), uniqueNumbers.end());
    sort(v.begin(), v.end());

    dfs(0, 0, 0);
    return 0;
}
