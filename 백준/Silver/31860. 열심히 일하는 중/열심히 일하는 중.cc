#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int aa = 0;
int cnt = 0;
int func(int x) {
	return aa / 2 + x;
}

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, K; cin >> N >> M >> K;
	priority_queue<int>pq;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		pq.push(num);
	}
	vector<int>v;
	while (!pq.empty())
	{
		int ttop = pq.top();
		pq.pop();
		if (ttop <= K) continue;
		int tmp = func(ttop);
		cnt++;
		pq.push(ttop - M);
		aa = tmp;
		v.push_back(tmp);

	}
	cout << cnt << "\n";
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << "\n";
	}
	return 0;
}

