import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private final int mod = 1000000000;

    private int[][] dp;

    public void solution() throws IOException {
        input();
        init();
        output(getAnswer());
    }

    private int getAnswer() {
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) sum = (sum + dp[N][i]) % mod;

        return sum;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void init() {
        dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 0;
        }

        dp[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }
}
