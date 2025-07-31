import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int answer = 0;

    private int[][] map;
    private final int[] da = {0, 0, 1, -1, -1, 1, 1, -1};
    private final int[] db = {1, -1, 0, 0, 1, 1, -1, -1};

    public void solution() throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private int bfs(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Pair(a, b, 0));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int cnt = p.getCnt();

            for (int i = 0; i < 8; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < N && nb < M && !visited[na][nb]) {
                    if (map[na][nb] == 0) {
                        visited[na][nb] = true;
                        q.add(new Pair(na, nb, cnt + 1));
                    } else return cnt + 1;
                }
            }
        }

        return 0;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}

class Pair {
    private final int a;
    private final int b;
    private final int cnt;

    public Pair(int a, int b, int cnt) {
        this.a = a;
        this.b = b;
        this.cnt = cnt;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCnt() {
        return cnt;
    }
}