#include <iostream>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int eng[26] = { 0 };
	int T; cin >> T;
	string base; cin >> base;
	int result = 0;
	for (int i = 0; i < base.length(); i++)
	{
		eng[base[i] - 'A']++; 
	}

	for (int i = 0; i < T - 1; i++)
	{
		string comp; cin >> comp;  

		int base_len = base.length();
		int comp_len = comp.length();
		int copy_eng[26];

		copy(eng, eng + 26, copy_eng); 
		int same = 0;

		for (int j = 0; j < comp_len; j++)
		{
			if (copy_eng[comp[j] - 'A'] > 0)
			{
				copy_eng[comp[j] - 'A']--;
				same++;  
			}
		}
		if (base_len == comp_len) {
			if (same + 1 == base_len || same == base_len) {
				result++;
			}
		}
		else if (base_len - 1 == comp_len && same + 1 == base_len)
		{
			result++;
		}
		else if (base_len + 1 == comp_len && same + 1 == comp_len) {
			result++; 
		}
	}
	cout << result << "\n";
	return 0;
}