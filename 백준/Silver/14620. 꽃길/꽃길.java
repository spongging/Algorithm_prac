import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int minCost = Integer.MAX_VALUE;

    private int[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private boolean[][] visited;

    public void solution() throws IOException {
        inputAndInit();
        dfs(0, 1);
        output();
    }

    private void output() {
        System.out.println(minCost);
    }

    private void dfs(int idx, int level) {
        if (level == 4) {
            minCost = Math.min(minCost,getCost());
            return;
        }

        for (int i = idx; i < N * N; i++) {
            int a = i / N;
            int b = i % N;

            if (isBlowingPossible(a, b)) {
                blowing(a,b);
                dfs(i + 1, level + 1);
                unBlowing(a, b);
            }
        }
    }

    private int getCost() {
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    tmp += map[i][j];
                }
            }
        }

        return tmp;
    }

    private void unBlowing(int a, int b) {
        visited[a][b] = false;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            visited[na][nb] = false;
        }
    }
    private void blowing(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            visited[na][nb] = true;
        }
    }

    private boolean isBlowingPossible(int a, int b) {
        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && nb >= 0 && na < N && nb < N && !visited[na][nb]) {
                continue;
            }else return false;
        }

        return true;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        br.close();
    }
}