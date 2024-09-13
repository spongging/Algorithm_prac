#include <iostream>
#include <vector>
#include <algorithm>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	int N; cin >> N;
	if (N % 2 == 0) cout << "CY" << "\n";
	else cout << "SK" << "\n";

	return 0;
}