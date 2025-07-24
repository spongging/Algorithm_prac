import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, T;
    private int a1,a2,b1, b2;

    private int[][] arr;
    private long[][] dp;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        input();
        getPrefix();

        while (T > 0) {
            inputQuery();
            output(getAnswer());
            T--;
        }
    }

    private long getAnswer() {
        return dp[a2][b2] - dp[a2][b1 - 1] - dp[a1 - 1][b2] + dp[a1 - 1][b1 - 1];
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void getPrefix() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
    }

    private void inputQuery() throws IOException {
        String[] line = br.readLine().split(" ");

        a1 = Integer.parseInt(line[0]);
        b1 = Integer.parseInt(line[1]);
        a2 = Integer.parseInt(line[2]);
        b2 = Integer.parseInt(line[3]);
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new int[N + 1][M + 1];
        dp = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] line2 = br.readLine().split(" ");

            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(line2[j - 1]);
            }
        }

        T = Integer.parseInt(br.readLine().trim());
    }
}