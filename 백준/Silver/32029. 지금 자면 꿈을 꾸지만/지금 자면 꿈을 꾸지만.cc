#include <iostream>	
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll; 
vector<int>v; 
int N, A, B; 
int func(int X, int idx) {
	int cnt = 0;
	int sum = 0; 
	for (int i = 0; i < idx; i++)
	{
		if (sum + A <= v[i]) {
			cnt++;
			sum += A;
		}
	}
	sum += B * X; 
	for (int i = idx; i < N; i++)
	{
		if (sum + (A - X) <= v[i]) {
			cnt++;
			sum += A - X;
		}
	}
	return cnt;  
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> A >> B; 
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	int answer = 0;
	for (int X = 0; X < A; X++)
	{
		for (int i = 0; i < N; i++)
		{
			answer = max(answer, func(X, i));
		}
	}
	cout << answer << "\n"; 
	return 0;
}