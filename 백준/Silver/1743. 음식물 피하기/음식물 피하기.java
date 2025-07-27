import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N,M,K;
    private int maxArea = 0;

    private char[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    boolean[][] visited;

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#') {
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(maxArea);
    }

    private int bfs(int a, int b) {
        int cnt = 1;
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

                if (na >= 0 && na < N && nb >= 0 && nb < M && !visited[na][nb]) {
                    if (map[na][nb] == '#') {
                        visited[na][nb] = true;
                        cnt++;
                        q.add(new Pair(na, nb));
                    }
                }
            }
        }

        return cnt;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);
        
        map = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = '.';
            }
        }

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            map[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = '#';
        }
    }
}

class Pair {
    private int a;
    private int b;

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