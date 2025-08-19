import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, T;

    private int[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();
        output(bfs(0, 0));
    }

    private void output(int answer) {
        if (answer == -1) {
            System.out.println("Fail");
        }else System.out.println(answer);
    }

    private int bfs(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];

        q.add(new Pair(a, b, 0, false));
        visited[a][b][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int time = p.getTime();
            boolean isHas = p.isHas();

            if (aa == N - 1 && bb == M - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (!checkRange(na,nb)) continue;
                if (time>T) continue;

                if (!isHas) {
                    if (!visited[na][nb][0] && map[na][nb] != 1) {
                        visited[na][nb][0] = true;

                        if (map[na][nb] == 2) {
                            q.add(new Pair(na, nb, time + 1, true));
                        } else {
                            q.add(new Pair(na, nb, time + 1, false));
                        }
                    }
                } else {
                    if (!visited[na][nb][1]) {
                        visited[na][nb][1] = true;
                        q.add(new Pair(na, nb, time + 1, true));
                    }
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
        T = Integer.parseInt(line[2]);

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
    private final int time;
    private final boolean isHas;

    public Pair(int a, int b, int time, boolean isHas) {
        this.a = a;
        this.b = b;
        this.time = time;
        this.isHas = isHas;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getTime() {
        return time;
    }

    public boolean isHas() {
        return isHas;
    }
}