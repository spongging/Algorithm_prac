#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, a[10001], b[10001], c[10002];
pair<int, int> p[10001];
// 0308 다시 풀어볼것 
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	/*cin >> N;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v1.push_back(num);
	}
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v2.push_back(num);

		for (int j = 0; j < N; j++)
		{
			if (num == v1[j]) {
				v1[j] = i;
				break;
			}
		}
	}

	//staring lis

	int j = 0;
	lis.push_back(v1[j]);
	int i = 1;

	while (i < N)
	{
		if (lis[j] < v1[i])
		{
			lis.push_back(v1[i]);
			j++;
		}
		else
		{
			int idx = lower_bound(lis.begin(), lis.end(), v1[i]) - lis.begin();
			lis[idx] = v1[i];
		}
		p[i] = { j,v1[i] };
		i++;
	}*/

    cin >> N;
    for (int i = 1; i <= N; ++i) {
        int v;
        cin >> v;
        a[v] = i;
    }
    for (int i = 1; i <= N; ++i) cin >> b[i];
    for (int i = 1; i <= N; ++i) c[a[b[i]]] = i;

    vector<int> v;
    for (int i = 1; i <= N; ++i) {
        int j = lower_bound(v.begin(), v.end(), c[i]) - v.begin();
        if (j < v.size()) v[j] = c[i];
        else v.push_back(c[i]);
        p[i] = { j, c[i] };
    }

    int j = v.size() - 1;

    vector<int> result;
    for (int i = N; i > 0; --i) {
        if (p[i].first == j) {
            result.push_back(p[i].second); 
            j--;
        }
    }

    cout << result.size() << "\n";
    for (auto& p : result) p = b[p];
    sort(result.begin(), result.end());
    for (auto& p : result) cout << p << " ";

    return 0;
}
