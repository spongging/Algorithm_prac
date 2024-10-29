#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int N, vector<int>& dice) {
    sort(dice.begin(), dice.end());
    int ans = 0;
    
    int height = 0;
    bool new_tower = true;

    while (!dice.empty()) {
        bool flag = true;
        for (int i = 0; i < dice.size(); i++) {  // 가장 작은 값의 주사위부터 시작
            if (dice[i] >= height) {
                if (new_tower) {       // 새로운 탑에서 주사위를 쌓을 수 있으면
                    ans += 1;          // 탑 한 개 추가
                }
                dice.erase(dice.begin() + i); // 주사위 제거
                height += 1;
                new_tower = false;     // 탑 한 개 추가 했으니 false로 설정
                flag = false;
                break;                 // 조건을 만족하면 한번만 확인하고 끝냄
            }
        }
        
        // 주사위를 모두 확인했지만 조건을 만족하지 못한 경우, 새로운 탑을 쌓음
        if (flag) {
            height = 0;
            new_tower = true;
        }
    }
    
    return ans;
}

int main() {
    int N;
    cin >> N;
    vector<int> dice(N);
    for (int i = 0; i < N; i++) {
        cin >> dice[i];
    }
    
    cout << solution(N, dice) << "\n";
    return 0;
}
