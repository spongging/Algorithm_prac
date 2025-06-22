import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private boolean[][] visited;
    private long answer = 0;

    public void solution() throws IOException {
        input();
        backtracking(0);
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void backtracking(int level) {
        if (level == N * M) {
            if (!checking()) {
                answer++;
            }

            return;
        }

        visited[level / M][level % M] = true;
        backtracking(level + 1);
        visited[level / M][level % M] = false;
        backtracking(level + 1);
    }

    private boolean checking() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i != N - 1 && j != M - 1) {
                    if (visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        visited = new boolean[N][M];
    }
}




