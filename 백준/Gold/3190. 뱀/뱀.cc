#include <iostream>
#include <deque>
#include <vector>
using namespace std; 

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	int N, K; cin >> N;
	int time = 0; 
	int dir = 2; // 1 2 3 4 
	char arr[101][101] = { 'X' };
	bool visited[101][101] = { 0 };
	visited[0][0] = 1; 
	vector<pair<int, char>>v; 
	deque<pair<int, int>>dq; 
	dq.push_front({ 0,0 }); 
	cin >> K;	
	for (int i = 0; i < K; i++)
	{
		int j, k; cin >> j >> k;
		arr[j - 1][k - 1] = 'A'; 
	}
	int L; cin >> L;
	while (L--)
	{
		int a; char c; cin >> a >> c; 
		v.push_back({ a,c }); 
	}
	bool flag = 0; 
	// head move -> tail move
	while (!flag)
	{
		time++; 
		int headA = dq.front().first;
		int headB = dq.front().second;
		if (dir == 1) {
			headA -= 1;
			if (!visited[headA][headB] && headA >= 0 && headA < N && headB >= 0 && headB < N) {
				dq.push_front({ headA,headB });
				visited[headA][headB] = 1;
			}
			else
			{
				cout << time << "\n";
				flag = 1;
			}
		}
		else if (dir == 2) {
			headB += 1;
			if (!visited[headA][headB] && headA >= 0 && headA < N && headB >= 0 && headB < N) {
				dq.push_front({ headA,headB });
				visited[headA][headB] = 1;
			}
			else
			{
				cout << time << "\n";
				flag = 1;
			}
		}
		else if (dir == 3) {
			headA += 1;
			if (!visited[headA][headB] && headA >= 0 && headA < N && headB >= 0 && headB < N) {
				dq.push_front({ headA,headB });
				visited[headA][headB] = 1;
			}
			else
			{
				cout << time << "\n";
				flag = 1;
			}
		}
		else
		{
			headB -= 1;
			if (!visited[headA][headB] && headA >= 0 && headA < N && headB >= 0 && headB < N) {
				dq.push_front({ headA,headB });
				visited[headA][headB] = 1;
			}
			else
			{
				cout << time << "\n";
				flag = 1;
			}
		}
		if (arr[headA][headB] != 'A') {
			int taleA = dq.back().first;
			int taleB = dq.back().second;
			visited[taleA][taleB] = 0;
			dq.pop_back(); 
		}
		else arr[headA][headB] = 'X';
		//find
		for (int i = 0; i < v.size(); i++)
		{
			if (time == v[i].first) {
				if (v[i].second == 'D') {
					dir += 1;
					if (dir > 4) dir = 1;
				}
				else {
					dir -= 1;
					if (dir < 1) dir = 4;
				}
				break;
			}
		}
	}
	return 0;
}