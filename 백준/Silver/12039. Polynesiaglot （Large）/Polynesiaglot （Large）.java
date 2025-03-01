import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T; // TC
    private int C; // 자음
    private int V; // 모음
    private int L; // 길이
    private int answer;
    private int cnt = 0;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        inputT();
        while (T > 0) {
            cnt++;
            input();
            doDp();
            output(cnt);
            T--;
        }
    }

    private void output(int cnt) {
        System.out.println("Case #"+cnt+": "+answer);
    }

    private void doDp() {
        long[] dp = new long[501];
        dp[0] = 1;
        dp[1] = V;

        for (int i = 2; i <= L; i++) {
            dp[i] = (C * V * dp[i - 2] + V * dp[i - 1]) % 1000000007;
        }

        answer = (int) dp[L];
    }

    private void inputT() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        C = Integer.parseInt(line[0]);
        V = Integer.parseInt(line[1]);
        L = Integer.parseInt(line[2]);
    }
}