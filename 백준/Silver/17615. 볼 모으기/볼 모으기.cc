#include <iostream>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	int N; cin >> N;
	string s; cin >> s; 
	int lastred = 0; int lastblue = 0; 
	for (int i = 0; i < N; i++)
	{
		if (s[i] == 'R') {
			lastred = i;
		}
		else lastblue = i;
	}
	int red = 0; int blue = 0; 
	for (int i = 0; i <= lastblue; i++)
	{
		if (s[i] == 'R') {
			red++;
		}
		
	}
	for (int i = 0; i <= lastred; i++)
	{
		if (s[i] == 'B') {
			blue++; 
		}
	}
	cout << min(blue, red) << "\n";
	return 0;
}