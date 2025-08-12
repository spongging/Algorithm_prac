import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private int[][] map;
    private boolean[][] visited;

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    searchPossibleQ(i, j);

                } else if (map[i][j] == 2) {
                    searchPossibleK(i, j);
                }
            }
        }

        output(getAnswer());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getAnswer() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void searchPossibleK(int a, int b) {
        int[] da = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] db = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (check(na, nb)) {
                visited[na][nb] = true;
            }
        }
    }

    private void searchPossibleQ(int a, int b) {
        // up
        for (int i = 1; i < N; i++) {
            int na = a - i;
            int nb = b;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        // down
        for (int i = 1; i < N; i++) {
            int na = a + i;
            int nb = b;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        // right
        for (int i = 1; i < N; i++) {
            int na = a;
            int nb = b + i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        // left
        for (int i = 1; i < N; i++) {
            int na = a;
            int nb = b - i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        // 대각
        for (int i = 1; i < N; i++) {
            int na = a - i;
            int nb = b + i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        for (int i = 1; i < N; i++) {
            int na = a + i;
            int nb = b + i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        for (int i = 1; i < N; i++) {
            int na = a + i;
            int nb = b - i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }

        for (int i = 1; i < N; i++) {
            int na = a - i;
            int nb = b - i;

            if (check(na, nb)) {
                visited[na][nb] = true;
            }else break;
        }


    }

    private boolean check(int na, int nb) {
        if (na >= 0 && nb >= 0 && na < N && nb < M) {
            if (map[na][nb] == 0) {
                return true;
            }
        }

        return false;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        line = br.readLine().split(" ");
        int qCnt = Integer.parseInt(line[0]);
        for (int i = 0; i < qCnt; i++) {
            int r = Integer.parseInt(line[1 + i * 2]) - 1;
            int c = Integer.parseInt(line[2 + i * 2]) - 1;

            map[r][c] = 1;
        }

        line = br.readLine().split(" ");
        int kCnt = Integer.parseInt(line[0]);
        for (int i = 0; i < kCnt; i++) {
            int r = Integer.parseInt(line[1 + i * 2]) - 1;
            int c = Integer.parseInt(line[2 + i * 2]) - 1;

            map[r][c] = 2;
        }

        line = br.readLine().split(" ");
        int pCnt = Integer.parseInt(line[0]);
        for (int i = 0; i < pCnt; i++) {
            int r = Integer.parseInt(line[1 + i * 2]) - 1;
            int c = Integer.parseInt(line[2 + i * 2]) - 1;

            map[r][c] = 3;
        }
    }

}