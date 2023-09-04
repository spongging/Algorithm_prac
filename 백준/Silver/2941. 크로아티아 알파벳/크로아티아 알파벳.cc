#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	int count = 0;
	string alphabet;	// 크로아티아 알파벳 문자열 받기
	cin >> alphabet;

	// 크로아티아 알파벳인 경우 카운트
	for (int i = 0; i < alphabet.size(); i++) {
		// 1. c=
		if (alphabet[i] == 'c' && alphabet[i + 1] == '=') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 2. c-
		else if (alphabet[i] == 'c' && alphabet[i + 1] == '-') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 3. dz=
		else if (alphabet[i] == 'd' && alphabet[i + 1] == 'z' && alphabet[i + 2] == '=') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			alphabet[i + 2] = '0';
			count++;
			i += 2;
		}
		// 4. d-
		else if (alphabet[i] == 'd' && alphabet[i + 1] == '-') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 5. lj
		else if (alphabet[i] == 'l' && alphabet[i + 1] == 'j') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 6. nj
		else if (alphabet[i] == 'n' && alphabet[i + 1] == 'j') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 7. s=
		else if (alphabet[i] == 's' && alphabet[i + 1] == '=') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
		// 8. z=
		else if (alphabet[i] == 'z' && alphabet[i + 1] == '=') {
			alphabet[i] = '0';
			alphabet[i + 1] = '0';
			count++;
			i++;
		}
	}

	// 0 이 아닌 부분 카운트
	for (int j = 0; j < alphabet.size(); j++) {
		if (alphabet[j] != '0') {
			count++;
		}
	}

	cout << count;

}