#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	int N; cin >> N;
	vector<int>v;
	for (int i = 0; i < N; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	int result = 0; 
	while (v.size() > 1)
	{
		result++;
		v[0]--;
		 
		v[v.size() - 2] += v[v.size() - 1];
		v.pop_back();

		if (v[0] == 0) {
			for (int i = 0; i < v.size()-1; i++) {
				v[i] = v[i + 1];
			}
			v.pop_back(); 
		}

	}
	cout << result << "\n"; 
	return 0;
}