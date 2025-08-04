import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int cheezeCnt = 0;
    private int boundaryCnt = 0;
    private int time = 0;

    private int[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private final ArrayList<Pair> boundaryArr = new ArrayList<>();

    public void solution() throws IOException {
        input();

        while (true) {
            time++;
            boundaryArr.clear();
            bfs();

            if (cheezeCnt - boundaryCnt == 0) {
                break;
            }

            melting();
        }

        output();
    }

    private void melting() {
        for (Pair p : boundaryArr) {
            map[p.getA()][p.getB()] = 0;
        }

        cheezeCnt -= boundaryCnt;
    }

    private void output() {
        System.out.println(time);
        System.out.println(cheezeCnt);
    }

    private void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        boundaryCnt = 0;

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < N && nb < M && !visited[na][nb]) {
                    visited[na][nb] = true;

                    if (map[na][nb] == 1) {
                        boundaryCnt++;
                        boundaryArr.add(new Pair(na, nb));
                    } else q.add(new Pair(na, nb));
                }
            }
        }
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
                int tmp = Integer.parseInt(line[j]);
                map[i][j] = tmp;

                if (tmp == 1) {
                    cheezeCnt++;
                }
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