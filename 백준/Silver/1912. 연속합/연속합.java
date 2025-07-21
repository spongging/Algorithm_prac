import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[] dp;
    private final ArrayList<Integer> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        System.out.println(getAnswer());
    }

    private long getAnswer() {
        dp[0] = arr.get(0);

        for (int i = 1; i < N; i++) {
            int tmp = arr.get(i) + dp[i - 1];
            dp[i] = Math.max(tmp, arr.get(i));
        }

        int max = dp[0];
        for (int num : dp) {
            if (max < num) {
                max = num;
            }
        }

        return max;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        dp = new int[N];
    }
}