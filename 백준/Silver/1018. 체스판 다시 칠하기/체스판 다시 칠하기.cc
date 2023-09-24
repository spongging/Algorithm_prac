#include <iostream>
#include <vector>
using namespace std;

string WB[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};
string BW[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};

string board[50];

int WB_cnt(int x, int y){
    int cnt = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if(board[x + i][y + j] != WB[i][j])
            cnt += 1;
        }
    }

    return cnt;
}
int BW_cnt(int x, int y) {
    int cnt = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if (board[x + i][y + j] != BW[i][j])
            cnt += 1;
        }
    }
    return cnt;
}
int main() {
    pair<int, int>p1;
    int result = 12345;
    int tmp;
    cin >> p1.first >> p1.second;
    for (int i = 0; i < p1.first; i++)
    {
        cin >> board[i];
    }
    for (int i = 0; i+8 <= p1.first; i++)
    {
        for (int j = 0; j + 8 <= p1.second; j++)
        {
            tmp = min(WB_cnt(i, j), BW_cnt(i, j));
            if (result >= tmp)
            {
                result = tmp;
            }
        }
    }
    cout << result << endl;
    return 0;
}