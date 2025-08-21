import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, initA, initB;

    private int[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();
        output(bfs(initA, initB));
    }

    private void output(int answer) {
        if (answer == -1) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(answer);
        }
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

            if (map[aa][bb] == 3 || map[aa][bb] == 4 || map[aa][bb] == 5) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (checkRange(na, nb) && !visited[na][nb] && map[na][nb] != 1) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb, cnt + 1));
                }
            }
        }

        return -1;
    }

    private boolean checkRange(int na, int nb) {
        return na >= 0 && nb >= 0 && na < N && nb < M;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

                if (s.charAt(j) == '2') {
                    initA = i;
                    initB = j;
                }
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