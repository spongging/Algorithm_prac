#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(string x, string y) {
    int xsum = 0;
    int ysum = 0;

    if (x.size() != y.size()) {
        return x.size() < y.size();
    }

    for (int i = 0; i < x.size(); i++) {
        if(x[i]>='0' && x[i]<='9')
        xsum += x[i] - '0';
    }
    for (int i = 0; i < y.size(); i++) {
        if (y[i] >= '0' && y[i] <= '9')
        ysum += y[i] - '0';
    }

    if (xsum != ysum) {
        return xsum < ysum;
    }

    return x < y;

}

int main() {
  
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL); 
    
    int n; cin >> n;
    vector<string>v; 

    for (int i = 0; i < n; i++) {
        string x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end(), compare); 
    //2
    for (auto a : v) cout << a << "\n";
    return 0;
}
