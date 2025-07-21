import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, n;
    private int target;
    private int totalSum;

    private int[] dp;
    private final ArrayList<Integer> arr = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            input();
            init();
            executeDp();
            output(getAnswer());
            T--;
        }
    }

    private Pair getAnswer() {
        for (int i = target; i < dp.length; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                return new Pair(i, dp[i]);
            }
        }

        return new Pair(0, 0);
    }

    private void output(Pair p) {
        System.out.println(p.getCost() + " " + p.getCnt());
    }

    private void executeDp() {
        for (int coin : arr) {
            for (int i = dp.length - 1; i >= coin; i--) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
    }

    private void init() {
        dp = new int[totalSum + 1];

        for (int i = 0; i <= totalSum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
    }

    private void input() throws IOException {
        totalSum = 0;
        target = Integer.parseInt(br.readLine().trim());
        n = Integer.parseInt(br.readLine().trim());

        arr.clear();
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine().trim());
            arr.add(coin);
            totalSum += coin;
        }

        Collections.sort(arr);
    }
}

class Pair {
    private final int cost;
    private final int cnt;

    public Pair(int cost, int cnt) {
        this.cost = cost;
        this.cnt = cnt;
    }

    public int getCost() {
        return cost;
    }

    public int getCnt() {
        return cnt;
    }
}