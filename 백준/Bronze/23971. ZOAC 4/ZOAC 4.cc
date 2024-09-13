#include <iostream>
using namespace std; 
int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		 
	int H, W, N, M; cin >> H >> W >> N >> M;
	int tmpa = N + 1;
	int tmpb = M + 1;
	int idx = 0;
	int cnt = 1; int result = 0;
	while (1)
	{
		idx += tmpa; 
		if (idx < H) { 
			cnt++; 
		}
		else {
			result += cnt; 
			break;
		}
	}
	idx = 0; cnt = 1; 
	while (1)
	{
		idx += tmpb;
		if (idx < W) {
			cnt++;
		}
		else {
			result *= cnt;
			break;
		}
	}
	cout << result << "\n";
	return 0;
}