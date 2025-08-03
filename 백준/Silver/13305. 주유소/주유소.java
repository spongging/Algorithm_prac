import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final ArrayList<Integer> dists = new ArrayList<>();
    private final ArrayList<Integer> costs = new ArrayList<>();

    public void solution() throws IOException {
        input();
        output(getAnswer());
    }

    private long getAnswer() {
        int minCost = Integer.MAX_VALUE;
        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            int cur = costs.get(i);
            if (cur < minCost) minCost = cur;

            sum += (long) minCost * dists.get(i);
        }

        return sum;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            dists.add(Integer.parseInt(line[i]));
        }

        line = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            costs.add(Integer.parseInt(line[j]));
        }
    }
}