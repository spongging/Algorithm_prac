import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int M;
    private int N;
    private int[][] arr;
    private boolean[][] visited;
    private int answer = 0;

    public void solution() throws IOException {
        input();
        findingTop();
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void findingTop() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j)) {
                        answer++;
                    }
                }
            }
        }
    }

    private boolean bfs(int a, int b) {
        boolean flag = true;
        int[] da = {0, 0, 1, -1, -1, 1, 1, -1}; // 왼위 윈아 오아 오위
        int[] db = {1, -1, 0, 0, 1, 1, -1, -1};
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

                if (na >= 0 && na < N && nb >= 0 && nb < M) {
                    int tmp = arr[na][nb];

                    if (tmp > arr[aa][bb]) {
                        flag = false;
                    }

                    if (!visited[na][nb] && tmp == arr[aa][bb]) {
                        visited[na][nb] = true;
                        q.add(new Pair(na, nb));
                    }
                }
            }
        }

        return flag;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line2 = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line2[j]);
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