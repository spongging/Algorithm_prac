import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, K;

    private final ArrayList<Integer> nums = new ArrayList<>();
    private int[] dp = new int[50002];

    public void solution() throws IOException {
        input();
        executeDp();
    }

    private void executeDp() {
        for (int i = 0; i <= 50001; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int n : nums) {
            dp[n] = 1;
        }

        for (int i = 1; i <= 50001; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] = Math.min(dp[i], dp[i - n] + 1);
                }
            }

            if (dp[i] > K) {
                if (i % 2 == 0) {
                    output(i, "holsoon");
                } else {
                    output(i, "jjaksoon");
                }

                break;
            }

            if (i==50001) output(i,"jjaksoon");
        }
    }

    private void output(int i, String name) {
        System.out.println(name + " win at " + i);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        String[] line = br.readLine().split(" ");
        for (String s : line) {
            nums.add(Integer.parseInt(s));
        }

        K = Integer.parseInt(br.readLine().trim());
    }
}