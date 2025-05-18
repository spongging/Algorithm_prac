import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private char[][] arr;
    private boolean[][] visitedW;
    private boolean[][] visitedB;

    public void solution() throws IOException {
        input();
        output(getPowerOfWhite(),getPowerOfBlue());
    }

    private int bfs(int a, int b, char c) {
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));

        int cnt = 1;

        if (c == 'W') {
            visitedW[a][b] = true;
        } else {
            visitedB[a][b] = true;
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && na < M && nb >= 0 && nb < N) {
                    if (c == 'W') {
                        if (!visitedW[na][nb] && arr[na][nb] == 'W') {
                            visitedW[na][nb] = true;
                            q.add(new Pair(na, nb));
                            cnt++;
                        }
                    } else if (!visitedB[na][nb] && arr[na][nb] == 'B'){
                        if (!visitedB[na][nb]) {
                            visitedB[na][nb] = true;
                            q.add(new Pair(na, nb));
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    private int getPowerOfWhite() {
        int power = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'W' && !visitedW[i][j]) {
                    power += (int) Math.pow(bfs(i, j, 'W'), 2);
                }
            }
        }

        return power;
    }

    private int getPowerOfBlue() {
        int power = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'B' && !visitedB[i][j]) {
                    power += (int) Math.pow(bfs(i, j, 'B'), 2);
                }
            }
        }

        return power;
    }

    private void output(int answer1, int answer2) {
        System.out.println(answer1 + " " + answer2);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new char[M][N];
        visitedW = new boolean[M][N];
        visitedB = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line2 = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line2.charAt(j);
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