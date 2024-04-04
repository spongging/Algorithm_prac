#include <iostream>
#include <vector>
using namespace std;

int K;
vector<int>v[11];
int arr[1025];

void func(int st, int ed, int cnt) {
    if (st == ed) {
        v[cnt].push_back(arr[st]);
        return;
    }
    int mid = (st + ed) / 2;
    v[cnt].push_back(arr[mid]);
    func(st, mid - 1, cnt+1);
    func(mid + 1, ed, cnt+1);
    return;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> K;
    int num;
    int i = 0;
    while (cin >> num)
    {
        arr[i] = num;
        i++;
    }

    func(0, i - 1, 0);
    for (int i = 0; i < K; i++)
    {
        for (int j = 0; j < v[i].size(); j++)
        {
            cout << v[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;

}

