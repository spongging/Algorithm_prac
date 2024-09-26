#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

// 구조체를 사용하여 BFS의 상태를 정의
struct State {
    int x;
    int y;
    int next_move_type; // 0: 다음 동작은 move1, 1: 다음 동작은 move2
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int a, b, c, d;
    cin >> a >> b;
    cin >> c >> d;

    // 동작 유형별로 가능한 모든 움직임을 미리 계산
    vector<pair<int, int>> move1_moves;
    vector<pair<int, int>> move2_moves;

    // move1: (a, b)의 8가지 방향
    int deltas1[8][2] = {
        {a, b}, {a, -b}, {-a, b}, {-a, -b},
        {b, a}, {b, -a}, {-b, a}, {-b, -a}
    };
    for (auto& delta : deltas1) {
        move1_moves.emplace_back(delta[0], delta[1]);
    }

    // move2: (c, d)의 8가지 방향
    int deltas2[8][2] = {
        {c, d}, {c, -d}, {-c, d}, {-c, -d},
        {d, c}, {d, -c}, {-d, c}, {-d, -c}
    };
    for (auto& delta : deltas2) {
        move2_moves.emplace_back(delta[0], delta[1]);
    }

    // 방문 배열: visited[x][y][move_type]
    // move_type: 0 (다음은 move1), 1 (다음은 move2)
    // 따라서 현재는 마지막으로 move2를 수행한 상태로 다음은 move1을 수행해야 함
    // 또는 마지막으로 move1을 수행한 상태로 다음은 move2를 수행해야 함
    vector<vector<vector<bool>>> visited(n, vector<vector<bool>>(n, vector<bool>(2, false)));

    // BFS 큐 초기화
    queue<State> q;

    // 시작점 (0,0)에서 첫 번째 동작 유형으로 시작
    q.push(State{ 0, 0, 0 });
    visited[0][0][0] = true;

    // 시작점 (0,0)에서 두 번째 동작 유형으로 시작
    q.push(State{ 0, 0, 1 });
    visited[0][0][1] = true;

    while (!q.empty()) {
        State current = q.front();
        q.pop();

        int x = current.x;
        int y = current.y;
        int move_type = current.next_move_type;

        // 다음에 수행할 동작 유형에 따른 이동 선택
        vector<pair<int, int>> current_moves;
        if (move_type == 0) {
            current_moves = move1_moves;
        }
        else {
            current_moves = move2_moves;
        }

        for (auto& delta : current_moves) {
            int new_x = x + delta.first;
            int new_y = y + delta.second;

            // 격자 내에 있는지 확인
            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
                // 다음 동작 유형은 현재 동작과 번갈아가므로 1 - move_type
                int next_move_type = 1 - move_type;

                if (!visited[new_x][new_y][next_move_type]) {
                    visited[new_x][new_y][next_move_type] = true;
                    q.push(State{ new_x, new_y, next_move_type });
                }
            }
        }
    }

    // 모든 방문한 타일 세기
    int total = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (visited[i][j][0] || visited[i][j][1]) {
                total++;
            }
        }
    }

    cout << total << "\n";

    return 0;
}
