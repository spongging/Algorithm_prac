#include <string>
#include <vector>
using namespace std;

int solution(string A, string B) {
    int answer = 0;
    if (A == B) {
        int answer = 0;
        return answer;
    }
    for (int i = A.length() - 1; i >= 0; i--) {
        string s = "";
        int idx = i;
        answer++;
        int cnt = 0;
        while (cnt != A.length()) {
            if (idx == A.length()) {
                idx = 0;
            }
            s += A[idx];
            idx++;
            cnt++;
        }
        if (s == B) {
            break;
        }
    }
    if (answer >= A.length()) {
        answer = -1;
    }
    return answer;
}