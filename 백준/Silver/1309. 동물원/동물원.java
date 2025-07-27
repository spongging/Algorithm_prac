import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private long[] dp;

    public void solution() throws IOException {
        input();
        init();
        output(getAnswer());
    }

    private long getAnswer() {
        for (int i = 3; i <= 100000; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }

        return dp[N];
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void init() {
        dp = new long[1000001];
        dp[1] = 3;
        dp[2] = 7;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }
}