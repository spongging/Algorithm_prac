#include <iostream>

using namespace std;



void prt_space(int n);

void prt_star(int n);



int main() {

    int n;

    cin >> n;

    for (int i = 1; i < n+1; i++) {

        int total = 2 * n - 1;

        int star = 2 * i - 1;

        prt_space((total - star) / 2);

        prt_star(star);

        cout << endl;

    }

    for (int i = n-1; i >0; i--) {

    int total = 2 * n - 1;

    int star = 2 * i - 1;

    prt_space((total - star) / 2);

    prt_star(star);

        if (i != 1) {

        cout << endl;

        }

    }

return 0;

}



void prt_space(int n) {

    for (int i = 0; i < n; i++) {

        cout << " ";

    }

}



void prt_star(int n) {

    for (int i = 0; i < n; i++) {

        cout << "*";

    }

}