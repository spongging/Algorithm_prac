#include<iostream>
using namespace std;

int memo[9];
int N, M;

void recursion(int x)
{
	if (x == M + 1)
	{
		for (int i = 1; i <= M; i++)
			cout << memo[i] << " ";
		cout << "\n";
	}	

	else
	{
		for (int i = 1; i <= N; i++)
		{
			memo[x] = i;
			recursion(x + 1);
			
		}
	}
}

int main()
{
	cin >> N >> M;
	recursion(1);
}