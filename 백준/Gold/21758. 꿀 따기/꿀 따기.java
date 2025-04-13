import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arr = new ArrayList<>();
    private int[] sum;

    public void solution() throws IOException {
        input();
        initSumArr();
        output(findMaxHoney());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int findMaxHoney() {
        int max = 0;

        // 벌-통-벌
        for (int i = 2; i < N; i++) {
            int tmp = (sum[i] - sum[1]) + (sum[sum.length - 2] - sum[i - 1]);
            max = Math.max(max, tmp);
        }

        // 벌-벌-통
        for (int i = 2; i < N; i++) {
            int tmp = (sum[N] - sum[1] - arr.get(i)) + (sum[N] - sum[i]);
            max = Math.max(max, tmp);
        }

        // 통-벌-벌
        for (int i = 2; i < N; i++) {
            int tmp = (sum[N - 1] - arr.get(i)) + sum[i - 1];
            max = Math.max(max, tmp);
        }

        return max;
    }

    private void initSumArr() {
        sum = new int[N + 1];
        sum[0] = 0;

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + arr.get(i);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        arr.add(0);
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
    }

}