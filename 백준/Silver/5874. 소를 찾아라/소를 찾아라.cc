#include <iostream>
#include <vector>	
using namespace std;
int arr1[50001] = { 0 };
int arr2[50001] = { 0 };
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string s; cin >> s;
	int arr1size = 1;  
	int arr2size = 1; 
	int idxv1 = 0;
	int idxv2 = 0;
	int st = 0; int ed = 1; 
	bool flag = 0; 
	while (ed < s.length())
	{
		if (s[st] == s[ed] && s[st] == '(') {
			if (flag == 1) {
				arr1size++; 
				idxv1++;
				flag = 0; 
			}
			arr1[idxv1]++;
		}
		else if (s[st] == s[ed] && s[st] == ')') {
			idxv2 = idxv1;  
			arr2[idxv2]++; 
			flag = 1; 
		}
		st++; ed++;
	}
	int result = 0; 
	for (int i = 0; i < arr1size ; i++)
	{
		for (int j = i; j < arr1size; j++)
		{
			result += arr1[i] * arr2[j];
		}
	}
	cout << result << "\n"; 
	return 0;
}