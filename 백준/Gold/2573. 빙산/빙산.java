import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int time = 0;


    private int[][] map;
    private boolean[][] visited;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();

        while (true) {
            visited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            if (cnt >= 2) {
                output(time);
                System.exit(0);

            } else if (cnt == 0) {
                output(0);
                System.exit(0);

            }

            melting();
            time++;
        }
    }

    private void melting() {
        int[][] tmpMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    int cnt = checkSea(i, j);
                    int tmp = map[i][j] - cnt;

                    if (tmp<0) tmp = 0;

                    tmpMap[i][j] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(tmpMap[i], 0, map[i], 0, M);
        }
    }

    private int checkSea(int a, int b) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (checkRange(na, nb) && map[na][nb] == 0) {
                cnt++;
            }
        }

        return cnt;
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

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (checkRange(na, nb) && !visited[na][nb] && map[na][nb] != 0) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }
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