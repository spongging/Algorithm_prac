import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int C;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[][] arr;
    private boolean[] visited;
    private int result;

    public void solution() throws IOException {
        C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            input();
            backtracking(0, 0);
            output();
        }
    }

    private void output() {
        System.out.println(result);
    }

    private void backtracking(int level, int sum) {
        if (level == 11) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!visited[i] && arr[level][i] != 0) {
                visited[i] = true;
                backtracking(level + 1, sum + arr[level][i]);
                visited[i] = false;
            }
        }
    }

    private void input() throws IOException {
        arr = new int[11][11];
        visited = new boolean[11];

        result = 0;

        for (int i = 0; i < 11; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < 11; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}