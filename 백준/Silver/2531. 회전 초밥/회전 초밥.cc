#include <iostream>
#include <vector>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	vector<int>v;  
	int result = 0; 
	int N, D, K, C; cin >> N >> D >> K >> C;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;  
		v.push_back(num);  
	}
	for (int i = 0; i < N; i++)
	{
		int coupon = 1;
		int cnt = 0;
		bool visited[3001] = { 0 };
		for (int j = i; j < i + K; j++)
		{
			if (!visited[v[j % N]]) {
				visited[v[j % N]] = 1;
				cnt++;
			}
			if (v[j % N] == C) {
				coupon = 0;
			}
		}
		result = max(result, cnt + coupon);
	}
	cout << result << "\n"; 
	return 0;
}