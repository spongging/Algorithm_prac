import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T;

    private final long[][] dp = new long[65][10];
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        init();

        while (T > 0) {
            output(getAnswer(input()));
            T--;
        }
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private long getAnswer(int n) {
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=dp[n][i];
        }

        return sum;
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
    }

    private int input() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        return n;
    }
}