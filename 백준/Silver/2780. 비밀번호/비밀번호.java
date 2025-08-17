import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, maxN = 0;

    private int[][] dp;
    private final ArrayList<Integer> queries = new ArrayList<>();

    public void solution() throws IOException {
        input();
        executeDp();

        for (int q : queries) {
            output(getAnswer(q));
        }
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private long getAnswer(int q) {
        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[q][i]) % 1234567;
        }

        return answer;
    }

    private void executeDp() {
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int j = 2; j <= maxN; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    dp[j][i] = dp[j - 1][7] % 1234567;

                } else if (i == 1) {
                    dp[j][i] = (dp[j - 1][2] + dp[j - 1][4]) % 1234567;

                } else if (i == 2) {
                    dp[j][i] = (dp[j - 1][1] + dp[j - 1][3] + dp[j - 1][5]) % 1234567;

                }else if (i == 3) {
                    dp[j][i] = (dp[j - 1][2] + dp[j - 1][6]) % 1234567;

                }else if (i == 4) {
                    dp[j][i] = (dp[j - 1][1] + dp[j - 1][5] + dp[j - 1][7]) % 1234567;

                }else if (i == 5) {
                    dp[j][i] = (dp[j - 1][2] + dp[j - 1][4] + dp[j - 1][6] + dp[j - 1][8]) % 1234567;

                }else if (i == 6) {
                    dp[j][i] = (dp[j - 1][3] + dp[j - 1][5] + dp[j - 1][9]) % 1234567;

                }else if (i == 7) {
                    dp[j][i] = (dp[j - 1][8] + dp[j - 1][4] + dp[j - 1][0]) % 1234567;

                }else if (i == 8) {
                    dp[j][i] = (dp[j - 1][5] + dp[j - 1][7] + dp[j - 1][9]) % 1234567;

                }else {
                    dp[j][i] = (dp[j - 1][6] + dp[j - 1][8]) % 1234567;

                }
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine().trim());
            maxN = Math.max(maxN, num);
            queries.add(num);
        }

        dp = new int[maxN + 1][10];
    }
}