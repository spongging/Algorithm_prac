import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int initA, initB , targetA, targetB;
    private int squareN, squareM;
    private int answer = 0;

    private int[][] map;
    private int[][] dp;
    private final int[] da = {0, 0, -1, 1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();
        executeDp();
        output(bfs());
    }

    private void output(boolean flag) {
        if (flag) {
            System.out.println(answer);
        } else System.out.println(-1);
    }

    private boolean bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Pair(initA, initB, 0));
        visited[initA][initB] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int cnt = p.getCnt();

            if (aa == targetA && bb == targetB) {
                answer = cnt;
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (checkRange(na, nb) && isMovingPossible(na, nb) && !visited[na][nb]) {
                    q.add(new Pair(na, nb, cnt + 1));
                    visited[na][nb] = true;
                }
            }
        }

        return false;
    }

    private boolean isMovingPossible(int na, int nb) {
        int na2 = na + squareN - 1;
        int nb2 = nb + squareM - 1;

        int tmp1 = dp[na2][nb2];
        int tmp2 = nb - 1 < 0 ? 0 : dp[na2][nb - 1];
        int tmp3 = na - 1 < 0 ? 0 : dp[na - 1][nb2];
        int tmp4 = (na - 1 >= 0 && nb - 1 >= 0) ? dp[na - 1][nb - 1] : 0;

        return (tmp1 - tmp2 - tmp3 + tmp4) == 0;
    }

    private boolean checkRange(int na, int nb) {
        return na >= 0 && nb >= 0 && na < N && nb < M && na + squareN - 1 < N && nb + squareM - 1 < M;
    }

    private void executeDp() {
        dp[0][0] = map[0][0];

        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().split(" ");

        squareN = Integer.parseInt(line[0]);
        squareM = Integer.parseInt(line[1]);
        initA = Integer.parseInt(line[2]) - 1;
        initB = Integer.parseInt(line[3]) - 1;
        targetA = Integer.parseInt(line[4]) - 1;
        targetB = Integer.parseInt(line[5]) - 1;
    }
}

class Pair {
    private final int a;
    private final int b;
    private final int cnt;

    public Pair(int a, int b, int cnt) {
        this.a = a;
        this.b = b;
        this.cnt = cnt;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCnt() {
        return cnt;
    }
}