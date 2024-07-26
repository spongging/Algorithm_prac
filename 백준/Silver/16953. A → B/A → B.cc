#include <iostream>
#include <queue>
#include <climits>
#include <string>
#include <unordered_set>
using namespace std;
typedef long long ll; 
int A, B; 
void bfs(int num) {
	queue<pair<ll, int>>q;
	unordered_set<ll>visited; 
	q.push({ num,0 });
	while (!q.empty())
	{
		ll tmp = q.front().first; 
		int cnt = q.front().second;
		q.pop(); 
		if (tmp == B) {
			cout << cnt + 1 << "\n";
			exit(0); 
		}
		if (visited.find(tmp)==visited.end()) {
			visited.insert(tmp); 
			ll tmp1 = tmp * 2; 
			if(tmp1<=B) q.push({ tmp1,cnt + 1 }); 
			string s = to_string(tmp) + '1';
			ll tmp2 = stoll(s);
			if (tmp2 <= B) q.push({ tmp2,cnt + 1 });
		}
	}
	cout << -1 << "\n";
}
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> A >> B;
	bfs(A);
	return 0;
}