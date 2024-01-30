#include <iostream> 
#include <vector>
#include <algorithm>
using namespace std;

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	int N; cin >> N;
	int cnt = 1; int result;
	vector<pair<int, int>>v;
	for (int i = 0; i < N; i++)
	{
		int a, b; cin >> a >> b;
		v.push_back(make_pair(b, a)); //end start
	}
	sort(v.begin(), v.end());
	int ed = v[0].first;
	for (int i = 1; i < N; i++)
	{
		if (ed <= v[i].second)
		{
			cnt++;
			ed = v[i].first;
		}
	}
	cout << cnt << "\n";
	return 0;
}