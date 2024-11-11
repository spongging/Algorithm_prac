#include <iostream>
#include <queue>
using namespace std;
int s;
int result;
bool visited[10000][10000] = { false };
void bfs() {
    queue<pair<pair<int, int>, int>>q;
    q.push({ {0,1},0 });
    visited[0][1] = true;
    while (!q.empty())
    {
        int clip = q.front().first.first;
        int screen = q.front().first.second;
        int cnt = q.front().second;
        if (screen == s) {
            cout << cnt << "\n";
            return;
        }
        q.pop();
        for (int i = 0; i < 3; i++)
        {
            int tmpclip = clip;
            int tmpscreen = screen;
            if (i == 0) {
                tmpclip = tmpscreen;
                if (!visited[tmpclip][tmpscreen]) {
                    visited[tmpclip][tmpscreen] = 1;
                    q.push({ {tmpclip,tmpscreen},cnt + 1 });
                }
            }
            else if (i == 1)
            {
                tmpscreen += tmpclip;
                if (!visited[tmpclip][tmpscreen]) {
                    visited[tmpclip][tmpscreen] = 1;
                    q.push({ {tmpclip,tmpscreen},cnt + 1 });
                }
            }
            else
            {
                if (tmpscreen == 0) continue;
                tmpscreen--;
                if (!visited[tmpclip][tmpscreen]) {
                    visited[tmpclip][tmpscreen] = 1;
                    q.push({ {tmpclip,tmpscreen},cnt + 1 });
                }
            }

        }
    }
}
int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> s;
    bfs();
    return 0;
}
