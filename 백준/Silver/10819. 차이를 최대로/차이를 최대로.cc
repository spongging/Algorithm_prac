#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
vector<int>v;
int MAX = 0;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int num; cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    do
    {
        vector<int>tmp;
        for (int i = 0; i < N - 1; i++)
        {
            int n1 = v[i];
            int n2 = v[i + 1];
            tmp.push_back(abs(n1 - n2));
        }
        int sum = 0;
        for (int i = 0; i < tmp.size(); i++)
        {
            sum += tmp[i];
        }
        MAX = max(MAX, sum);  

    } while (next_permutation(v.begin(), v.end()));

    cout << MAX << "\n"; 

    return 0;
}