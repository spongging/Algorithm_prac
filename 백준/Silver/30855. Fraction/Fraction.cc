#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;
int N;
bool TF = true;
stack <pair<long long, long long >>s;
long long gcd(long long a, long long b) {
	if (b == 0)
	{
		return a;
	}
	return gcd(b, a % b);
}
pair<long long, long long> calc(pair<long long, long long>x, pair<long long, long long>y,
	pair<long long, long long>z){
	pair<long long, long long>result;
	pair<long long, long long>tmp;
	tmp.first = y.first * z.second;
	tmp.second = y.second * z.first;
	long long aa = gcd(tmp.first, tmp.second);
	tmp.first /= aa;
	tmp.second /= aa;
	result.first = x.first * tmp.second + x.second * tmp.first;
	result.second = tmp.second * x.second;
	aa = gcd(result.first, result.second);
	result.first /= aa;
	result.second /= aa;
	return result; 
}
int main(void) {
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL); 
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		char c; cin >> c;
		if (c == '(')
		{
			s.push({ 0,1 });
		}
		else if (c != ')')
		{
			int num;
			num = c - '0';
			s.push({ num,1 });
		}
		else
		{
			vector<pair<long long, long long>>tmp; 
			if (s.size() <= 3)
			{
				TF = false;
			}
			else
			{
				for (int i = 0; i < 4; i++)
				{
					tmp.push_back(s.top()); 
					s.pop();
				}
				reverse(tmp.begin(), tmp.end());
				if (tmp[0].first!=0 || tmp[1].first==0 || tmp[2].first == 0 || tmp[3].first == 0)
				{
					TF = false; 
				}
				else
				{
					pair<long long, long long> tmp2;
					tmp2 = calc(tmp[1], tmp[2], tmp[3]);
					s.push(tmp2);
				}
			}
		}
		if (!TF)
		{
			break;
		}
	}
	if (!TF)
	{
		cout << -1 << "\n";
	}
	if (!s.empty())
	{
		if ((s.size() == 1 && s.top().first == 0) || s.size() >= 2)
		{
			cout << -1 << "\n";
		}
		else
		{
			cout << s.top().first << ' ' << s.top().second << "\n";
		}
	}
	else
	{
		cout << -1 << "\n";
	}
	return 0;
}
