#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int main(void)
{
	char arr[101];
	char word='a';
	int index[26];
	int i, len;
	int j = 0, z = 0; int aa;
	char pp;
	cin >> arr;
	len = strlen(arr);
	for ( i = 0; i < 26; i++)
	{
		index[i] = -1;
	}
	while (z < len)
	{

		for (i = 0; i <= len; i++)
		{
			pp = arr[i];
			word = 'a';
			j = 0;

			for (aa = 0; aa < 26; aa++)
			{

				if (pp == word)
				{
					if (index[j] != -1)
					{
						break;
					}
					else
					{
						index[j] = i;
						break;
					}
				}
				else
				{
					word = word + 1;
					j++;
				}
			}
		}
		z++;
	}
	for ( i = 0; i < 26; i++)
	{
		cout << index[i] << " ";
	}
}
