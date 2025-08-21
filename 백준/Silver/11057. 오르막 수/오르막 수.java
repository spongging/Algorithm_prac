import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private static final int mod = 10007;

    private long[][] dp;

    public void solution() throws IOException {
        input();
        init();
        executeDp();
        output(getAnswer());
    }

    private long getAnswer() {
        long tmp = 0;

        for (int i = 0; i < 10; i++) {
            tmp += dp[N][i];
        }

        return tmp % mod;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void executeDp() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
            }
        }
    }

    private void init() {
        dp = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 1;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
    }
}