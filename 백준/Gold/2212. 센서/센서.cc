#include <iostream> 
#include <vector>
#include <algorithm>
using namespace std;

int main(void){

	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);  

	int N, K; cin >> N >> K; 
	vector<int>v;
	vector<int>dis;
	int max = 0; int sum = 0;
	int tmp = 0;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}
	if (N == 1 || N <= K)
	{
		cout << 0 << "\n";
		return 0;
	}
	sort(v.begin(), v.end()); 
	for (int i = 0; i < N - 1; i++)
	{
		int st = v[i]; int ed = v[i + 1];
		int ds = ed - st; 
		sum += ds;
		if (ds > max) max = ds;
		dis.push_back(ds); 
	}
	sort(dis.begin(), dis.end());
	for (int i = dis.size() - 1; i >= dis.size() - (K - 1); i--)
	{
		sum -= dis[i];
	}
	cout << sum << "\n";

	return 0;
}
