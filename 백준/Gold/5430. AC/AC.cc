#include <iostream>
#include <deque>
#include <string>
using namespace std;

int T;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> T; 
	for (int i = 0; i < T; i++)
	{
		string p;
		deque<int>deq;
		int n;
		cin >> p;
		cin >> n; 
		string x; cin >> x; 
		string tmp = ""; 
		bool TF = false;
		bool TF2 = true;

		for (int i = 0; i < x.size(); i++)
		{
			if (isdigit(x[i]))
			{
				tmp += x[i];
			}
			else
			{
				if (!tmp.empty())
				{
					deq.push_back(stoi(tmp));
					tmp = "";
				}
			}
		}
		// 1234
		for (char aa : p) {
			if (aa=='R')
			{
				if (TF == true)
				{
					TF = false;
				}
				else TF = true;
			}
			else // 'D'
			{
				if (TF==false)
				{
					if (deq.empty())
					{
						cout << "error" << "\n";
						TF2 = false;
						break;
					}
					deq.pop_front();
				}
				else
				{
					if (deq.empty())
					{
						cout << "error" << "\n";
						TF2 = false;
						break;
					}
					deq.pop_back();
				}
			}
		}
		
		/////////// printing

		int size = deq.size();

		if (TF2 == true)
		{
			if (TF == true)
			{
				cout << "[";
				for (int i = 0; i < size; i++)
				{
					if (i == size - 1) 
					{
						int num = deq.back();
						deq.pop_back();
						cout << num;
					}
					else
					{
						int num = deq.back();
						deq.pop_back();
						cout << num << ",";
					}
				}
				cout << "]" << "\n";
			}
			else
			{
				cout << "[";
				for (int i = 0; i < size; i++)
				{
					if (i == size - 1)
					{
						int num = deq.front();
						deq.pop_front();
						cout << num;
					}
					else
					{
						int num = deq.front();
						deq.pop_front();
						cout << num << ",";
					}
				}
				cout << "]" << "\n";
			}
		}
	}

	return 0;
}