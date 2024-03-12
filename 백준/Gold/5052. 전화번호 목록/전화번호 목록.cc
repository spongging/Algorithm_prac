#include <iostream>
#include <vector>
using namespace std;

int t;

struct Trie
{
    Trie* node[10];
    bool finish;
    Trie() { // constructor
        finish = false; 
        for (int i = 0; i < 10; i++) node[i] = NULL; 
    }

    void insert(string str, int idx) {
        if (idx == str.size()) {
            finish = true; 
            return;
        }

        if (node[str[idx] - '0'] == NULL)
        {
            node[str[idx] - '0'] = new Trie();
        }

        node[str[idx] - '0']->insert(str, idx + 1);
    }

    bool find(string str, int idx) {
        if (idx == str.size())
        {
            return false;
        }
        if (finish == true)
        {
            return true;
        }
        if (node[str[idx] - '0'] == NULL)
        {
            return false;
        }

        return node[str[idx] - '0']->find(str, idx + 1);
    }


    void clear(void) {
        for (int i = 0; i < 10; i++) {
            if (node[i] != NULL) {
                node[i]->clear();
                delete node[i];
            }
        }
    }

};

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;


    while (t--)
    {
        int n; cin >> n;
        vector<string>v; 

        Trie* root = new Trie();
        int tmp = 0;
        for (int i = 0; i < n; i++)
        {
            string str; cin >> str;
            v.push_back(str); 
            root->insert(str, 0);
        }
        int i;
        for ( i = 0; i < n; i++)
        {
            if (root->find(v[i], 0))
            {
                cout << "NO" << "\n";
                break;
            }

        }
        if (i == n)
        {
            cout << "YES" << "\n";
        }
        root->clear();
        delete root;
    
    }
    return 0;
}