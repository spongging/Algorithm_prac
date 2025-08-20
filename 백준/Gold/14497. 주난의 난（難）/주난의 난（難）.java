import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, targetA, targetB, initA, initB;
    private int cnt = 0;

    private char[][] map;
    private final ArrayList<Pair> fallStudents = new ArrayList<>();
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();

        while (true) {
            cnt++;

            if (bfs(initA, initB)) {
                output();
                return;
            }

            update();
        }
    }

    private void update() {
        for (Pair p : fallStudents) {
            map[p.getA()][p.getB()] = '0';
        }
    }

    private void output() {
        System.out.println(cnt);
    }

    private boolean bfs(int initA, int initB) {
        fallStudents.clear();
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Pair(initA, initB));
        visited[initA][initB] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (!checkRange(na, nb)) continue;

                if (map[na][nb] == '1' && !visited[na][nb]) {
                    visited[na][nb] = true;
                    fallStudents.add(new Pair(na, nb));

                } else if (map[na][nb] == '0' && !visited[na][nb]) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));

                } else if (map[na][nb] == '#' ) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkRange(int na, int nb) {
        return na >= 0 && nb >= 0 && na < N && nb < M;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        initA = Integer.parseInt(line[0]) - 1;
        initB = Integer.parseInt(line[1]) - 1;
        targetA = Integer.parseInt(line[2]) - 1;
        targetB = Integer.parseInt(line[3]) - 1;

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
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