import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final ArrayList<Integer> arr = new ArrayList<>();
    private int[][] dp;

    public void solution() throws IOException {
        input();
        init();
        output(getAnswer());
    }

    private int getAnswer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N; j++) {
                if (i < j + 1) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - (j + 1)][j] + arr.get(j));
                }
            }
        }

        return dp[N][N - 1];
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void init() {
        dp = new int[N + 1][N];

        for (int i = 0; i < N; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = arr.get(0) * i;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
    }
}