import javax.swing.*;
import java.io.*;
import java.net.Inet4Address;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[] arr;
    private int[] dp;
    private int maxVal = 0;

    public void solution() throws IOException {
        input();
        init();
        doDp();
        output();
    }

    private void output() {
        System.out.println(N - maxVal);
    }

    private void doDp() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int num : dp) {
            maxVal = Math.max(maxVal, num);
        }
    }

    private void init() {
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}