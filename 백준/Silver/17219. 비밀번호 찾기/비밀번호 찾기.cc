#include <iostream>
#include <map>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    map<string, string>m;
    int N, M; cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        string a, b; cin >> a >> b;
        m[a] = b;
    }
    for (int i = 0; i < M; i++)
    {
        string a; cin >> a;
        cout << m[a] << "\n";
    }

    return 0;
}
