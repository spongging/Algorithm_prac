import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int w, h;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int[][] map;
    private boolean[][] visited;
    private final int[] da = {0, 0, 1, -1, -1, 1, 1, -1};
    private final int[] db = {1, -1, 0, 0, 1, 1, -1, -1};

    public void solution() throws IOException {
        while (true) {
            if (!input()) break;
            int answer = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }

            output(answer);
        }
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void bfs(int a, int b) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(a, b));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 8; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < h && nb < w && !visited[na][nb] && map[na][nb] == 1) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }
    }

    private boolean input() throws IOException {
        String[] line = br.readLine().split(" ");

        w = Integer.parseInt(line[0]);
        h = Integer.parseInt(line[1]);

        if (w==0 && h==0) return false;

        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        return true;
    }
}

class Pair {
    private final int a;
    private final int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}