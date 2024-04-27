#include <iostream>
#include <vector>
using namespace std;

vector<int>v;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int sungju = 0; // 보유 주식수
	int junju = 0;
	int N; cin >> N;

	for (int i = 0; i < 14; i++)
	{
		int num; cin >> num;
		v.push_back(num);
	}

	int junrest = N; // 남은 돈
	int sungrest = N;

	for (int i = 0; i < 14; i++)
	{
		int tmp = v[i];
		if (junrest >= tmp) {
			junju += junrest / tmp;
			junrest = junrest - (junju * tmp);
		}

	}

	int cnt1 = 0;
	int cnt2 = 0;

	for (int i = 1; i < 14; i++)
	{
		if (v[i] > v[i - 1]) {
			cnt1++;
			cnt2 = 0;
		}
		else if (v[i] < v[i - 1]) {
			cnt1 = 0;
			cnt2++;
		}
		else
		{
			cnt1 = 0;
			cnt2 = 0;
		}
		if (cnt1 == 3) {
			cnt1 = 0;
			if (sungju > 0) {
				sungrest += sungju * v[i];
				sungju = 0;
			}
		}
		if (cnt2 == 3) {
			cnt2 = 0;
			if (sungrest >= v[i]) {
				sungju += sungrest / v[i];
				sungrest = sungrest - (sungju * v[i]);
			}
		}
	}

	sungrest = sungrest + (v[13] * sungju);
	junrest = junrest + (v[13] * junju);

	if (sungrest > junrest) cout << "TIMING" << "\n";
	else if (sungrest < junrest) cout << "BNP" << "\n";
	else cout << "SAMESAME" << "\n";
	

    return 0;
}