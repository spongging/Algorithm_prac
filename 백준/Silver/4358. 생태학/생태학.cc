#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <iomanip>
using namespace std;   
 int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL); 
	
	string s; 
	int total = 0;
	map<string, double>m; 
	while (getline(cin, s))
	{
		if (!s.empty())
		{
			m[s]++;
			total++;
		}
	}
	// 소수점 4자리 고정 출력 설정
	cout << fixed << setprecision(4);

	// 나무 종을 사전순으로 출력
	for (auto it = m.begin(); it != m.end(); ++it) {
		double percentage = (it->second / total) * 100;
		cout << it->first << " " << percentage;
		if (next(it) != m.end()) {
			cout << "\n";  // 마지막 항목이 아닌 경우 개행
		}
	}
	return 0;
}