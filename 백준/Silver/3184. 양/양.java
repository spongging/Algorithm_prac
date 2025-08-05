import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int R, C;
    private int totalSheep = 0;
    private int totalWolf = 0;

    private char[][] map;
    private boolean[][] visited;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(totalSheep + " " + totalWolf);
    }

    private void bfs(int a, int b) {
        int sheepCnt = 0;
        int wolfCnt = 0;

        Queue<Pair> q = new LinkedList<>();
        visited[a][b] = true;
        q.add(new Pair(a, b));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            if (map[aa][bb] == 'o') {
                sheepCnt++;
            } else if (map[aa][bb] == 'v') {
                wolfCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < R && nb < C && !visited[na][nb] && map[na][nb] != '#') {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }

        if (sheepCnt > wolfCnt) {
            totalSheep += sheepCnt;
        } else totalWolf += wolfCnt;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

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