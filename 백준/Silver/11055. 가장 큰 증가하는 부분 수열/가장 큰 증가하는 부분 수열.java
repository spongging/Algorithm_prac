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
    private int[] dp;

    public void solution() throws IOException {
        input();
        executeDp();
        output(getAnswer());
    }

    private int getAnswer() {
        int tmp = dp[0];
        for (int i = 1; i < N; i++) {
            tmp = Math.max(tmp, dp[i]);
        }

        return tmp;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void executeDp() {
        for (int i = 0; i < N; i++) {
            dp[i] = arr.get(i);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr.get(j) > arr.get(i)) {
                    dp[j] = Math.max(dp[j], dp[i] + arr.get(j));
                }
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 0;
        }
        dp[0] = arr.get(0);
    }
}