#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;   
 int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL); 
	
	int K, L; cin >> K >> L;
	map<string, int>m; int cnt = 0; 
	for (int i = 0; i < L; i++)
	{
		string s; cin >> s;
		cnt++;  
		if (m[s] != 0) {
			m[s] = cnt;
		}
		else
		{
			m.erase(s);
			m[s] = cnt;
		}
	}
	int tmp = 1;
	vector<pair<int, string>>p;
	for (auto& pp : m) {
		p.push_back({ pp.second,pp.first });
	}
	sort(p.begin(), p.end());
	for (int i = 0; i < K; i++)
	{
		if (i > p.size())break;
		cout << p[i].second << "\n";
	}

	return 0;
}