import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] wine = new int[N+1];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine().trim());
        }

        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(wine[1]);
            return;
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            // 1) i번째 안 마심
            int case1 = dp[i-1];
            // 2) i-1 안 마심, i 마심
            int case2 = dp[i-2] + wine[i];
            // 3) i-2 안 마심, i-1&i 마심
            int case3 = dp[i-3] + wine[i-1] + wine[i];

            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(dp[N]);
    }
}
