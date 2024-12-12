#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// 두 개의 숫자 문자열을 더하는 함수
string addStrings(const string& a, const string& b) {
    string result = "";
    int carry = 0;
    int len_a = a.length();
    int len_b = b.length();
    int i = len_a - 1;
    int j = len_b - 1;

    while(i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if(i >= 0) {
            sum += a[i] - '0';
            i--;
        }
        if(j >= 0) {
            sum += b[j] - '0';
            j--;
        }
        carry = sum / 10;
        sum %= 10;
        result += to_string(sum);
    }

    // 결과 문자열을 뒤집어서 반환
    reverse(result.begin(), result.end());
    return result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    // 게임판 입력
    vector<vector<int>> grid(N, vector<int>(N));
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }

    // DP 테이블 초기화: 모든 값을 "0"으로 설정
    vector<vector<string>> dp(N, vector<string>(N, "0"));
    dp[0][0] = "1"; // 시작점 초기화

    // DP 테이블 채우기
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(dp[i][j] == "0") continue; // 현재 셀로 도달할 수 있는 경로가 없는 경우 건너뜀
            if(grid[i][j] == 0) continue;   // 더 이상 진행할 수 없는 경우

            int jump = grid[i][j];
            // 오른쪽으로 점프
            int right = j + jump;
            if(right < N) {
                dp[i][right] = addStrings(dp[i][right], dp[i][j]);
            }

            // 아래쪽으로 점프
            int down = i + jump;
            if(down < N) {
                dp[down][j] = addStrings(dp[down][j], dp[i][j]);
            }
        }
    }

    cout << dp[N-1][N-1] << "\n"; // 도착지의 경로 수 출력
    return 0;
}
