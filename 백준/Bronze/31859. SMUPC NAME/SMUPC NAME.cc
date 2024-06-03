#include <iostream>
#include <map>
#include <string>
using namespace std;

char arr[21];
map<char, bool>m;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	string s; cin >> s;
	string news = "";
	string news2 = "";

	int cnt = 0;

	for (int i = 0; i < s.length(); i++)
	{
		if (m[s[i]] == 1) {
			cnt++;
			continue;
		}
		m[s[i]] = 1;
		news += s[i];

	}


	news += to_string(cnt + 4);
	string tmp = to_string((N + 1906));
	for (int i = 0; i < tmp.length(); i++)
	{
		news2 += tmp[i];
	}
	
	for (int i = 0; i < news.length(); i++)
	{
		news2 += news[i];
	}
	string news3 = "";

	for (int i = news2.length() - 1; i >= 0; i--)
	{
		news3 += news2[i];
	}

	string news4 = "smupc_";
	for (int i = 0; i < news3.length(); i++)
	{
		news4 += news3[i];
	}

	cout << news4 << "\n";

	return 0;


}

