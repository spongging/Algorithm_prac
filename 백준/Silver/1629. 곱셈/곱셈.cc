#include <iostream>
using namespace std;
typedef long long ll;

ll a, b, c;  

ll func(ll b) {
	if (b == 0) return 1; // if power of 0 is always 1
	if (b == 1) return a % c; // reaching a final level of func
	ll tmp = func(b / 2) % c; 
	if (b % 2 == 0) return tmp * tmp % c; // if b is even number
	else return (tmp * tmp % c) * (a % c); // if b is odd number
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b >> c;
	cout << func(b) % c << "\n";

	return 0;
}

//Tmforlanswp