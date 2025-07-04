import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, K;
    private char[][] map;
    private int answer = 0;

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isPossible(i, j)) {
                    answer++;
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private boolean isPossible(int a, int b) {
        int na, nb;
        int cnt = 0;

        if (map[a][b] == 'C') {
            cnt++;
        }

        for (int i = 1; i <= N; i++) {
            na = a - i;
            nb = b;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a + i;
            nb = b;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a;
            nb = b - i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a;
            nb = b + i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a - i;
            nb = b + i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a + i;
            nb = b + i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a + i;
            nb = b - i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            na = a - i;
            nb = b - i;

            if (check(na, nb)) {
                if (map[na][nb] == 'C') {
                    cnt++;
                }
            }
        }

        return cnt == K;
    }

    private boolean check(int na, int nb) {
        return na > 0 && nb > 0 && na <= N && nb <= N;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        map = new char[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                map[i][j] = '.';
            }
        }

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            map[a][b] = 'C';
        }
    }
}
