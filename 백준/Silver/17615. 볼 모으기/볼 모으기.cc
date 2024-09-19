#include <iostream>
#include <climits>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL); 

	int N; cin >> N;
	string s; cin >> s; 
	int lastred = 0; int lastblue = 0; 
	int initred = INT_MAX; int initblue = INT_MAX; 
	for (int i = 0; i < N; i++)
	{
		if (s[i] == 'R') {
			initred = min(initred, i); 
			lastred = i;
		}
		else {
			lastblue = i;
			initblue = min(initblue, i);
		}
	}
	int red = 0; int blue = 0; 
	int rightresult, leftresult; 
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
	rightresult = min(red, blue);  
	red = 0; blue = 0;
	for (int i = N-1; i >= initred; i--)
	{
		if (s[i] == 'B') {
			blue++;
		}
	}
	for (int i = N-1; i >= initblue; i--)
	{
		if (s[i] == 'R') {
			red++;
		}
	}
	leftresult = min(red, blue);
	cout << min(rightresult, leftresult) << "\n";
	return 0;
}