#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;
double x, y, c;   
double func(double mid) {
    double a = sqrt(x * x - mid * mid);
    double b = sqrt(y * y - mid * mid);
    return (a * b) / (a + b);
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> x >> y >> c; 
    double left = 0;
    double right = min(x, y); 
    double result=0; 
    while (right - left > 0.000001)
    {
        double mid = (left + right) / 2.0;
        if (func(mid) >= c) {
            result = mid;
            left = mid;
        }
        else right = mid;
    }
    
    cout.precision(3);
    cout << fixed << result << "\n";

    return 0;

}