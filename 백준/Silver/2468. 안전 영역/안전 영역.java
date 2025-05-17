import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[][] arr;
    private int maxHeight = 0;
    private boolean[][] visited;

    public void solution() throws IOException {
        input();
        output(getMaxArea());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getMaxArea() {
        int maxAreaCnt = 0;
        for (int i = 0; i <= maxHeight; i++) {
            visited = new boolean[N][N];
            int tmpAreaCnt = 0;

            getFloodingArea(i);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        bfs(j, k);
                        tmpAreaCnt++;
                    }
                }
            }

            maxAreaCnt = Math.max(maxAreaCnt, tmpAreaCnt);
        }

        return maxAreaCnt;
    }

    private void bfs(int a, int b) {
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};

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

                if (na >= 0 && na < N && nb >= 0 && nb < N && !visited[na][nb]) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }
    }

    private void getFloodingArea(int level) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] <= level) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(line[j]);

                if (maxHeight < tmp) {
                    maxHeight = tmp;
                }

                arr[i][j] = tmp;
            }
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