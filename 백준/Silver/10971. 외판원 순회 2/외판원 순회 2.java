import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int answer = Integer.MAX_VALUE;

    private int[][] arr;
    private final ArrayList<Integer> nums = new ArrayList<>();
    private boolean[] visited;

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            nums.add(i);
            backTracking(1);
            visited[i] = false;
            nums.clear();
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void backTracking(int level) {
        if (level == N) {
            answer = Math.min(answer, getCost());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums.add(i);
                backTracking(level + 1);
                visited[i] = false;
                nums.remove(nums.size() - 1);
            }
        }
    }

    private int getCost() {
        int cost = 0;

        for (int i = 0; i < nums.size(); i++) {
            int cur, next;

            cur = nums.get(i);
            if (i == nums.size() - 1) {
                next = nums.get(0);
            } else next = nums.get(i + 1);

            if (arr[cur][next] == 0) {
                return Integer.MAX_VALUE;
            } else cost += arr[cur][next];
        }

        return cost;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
    }
}