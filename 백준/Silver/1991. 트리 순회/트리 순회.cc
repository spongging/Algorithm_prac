#include <iostream>
#include <vector>
using namespace std;

int N;
pair<char, char> v[26];

void preorder(char c) {

    cout << c;

    if (v[c - 'A'].first != '.') {
        preorder(v[c - 'A'].first);
    }
    if (v[c - 'A'].second != '.') {
        preorder(v[c - 'A'].second);
    }

    return;
}
void inorder(char c) {

    if (v[c - 'A'].first != '.') {
        inorder(v[c - 'A'].first);
    }
    cout << c;
    if (v[c - 'A'].second != '.') {
        inorder(v[c - 'A'].second);
    }

}
void postorder(char c) {
    if (v[c - 'A'].first != '.') {
        postorder(v[c - 'A'].first);
    }
    if (v[c - 'A'].second != '.') {
        postorder(v[c - 'A'].second);
    }
    cout << c;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        char root, left, right;
        cin >> root >> left >> right;
        v[root - 'A'].first = left;
        v[root - 'A'].second = right;
    }
    
    preorder('A');
    cout << "\n";
    inorder('A');
    cout << "\n";
    postorder('A');
    cout << "\n";

    return 0;

}
