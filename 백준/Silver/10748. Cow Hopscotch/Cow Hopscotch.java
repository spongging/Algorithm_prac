import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int R,C, K;
    private int[][] map;
    private long[][] dp;

    public void solution() throws IOException {
        input();
        init();
        System.out.println(getAnswer());
    }

    private long getAnswer() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                long cur = dp[i][j];

                for (int k = i + 1; k < R; k++) {
                    for (int l = j + 1; l < C; l++) {
                        if (map[i][j] != map[k][l]) {
                            dp[k][l] = (dp[k][l] + cur) % 1000000007;
                        }
                    }
                }
            }
        }

        return dp[R - 1][C - 1] % 1000000007;
    }

    private void init() {
        dp = new long[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j] = 0;
            }
        }

        dp[0][0] = 1;
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] line2 = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(line2[j]);
            }
        }
    }
}