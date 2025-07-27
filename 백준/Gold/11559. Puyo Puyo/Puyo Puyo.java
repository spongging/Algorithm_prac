import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int answer = 0;
    private boolean isSuccess;

    private final char[][] map = new char[12][6];
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private boolean[][] visited;

    public void solution() throws IOException {
        input();

        while (true) {
            visited = new boolean[12][6];
            isSuccess = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        if (bfs(i, j, map[i][j])) {
                            isSuccess = true;
                        }
                    }
                }
            }

            if (!isSuccess) {
                break;
            }

            answer++;
            for (int i = 0; i < 6; i++) {
                for (int j = 11; j >= 0; j--) {
                    if (map[j][i] != '.') {
                        falling(j, i, map[j][i]);
                    }
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void falling(int ca, int cb, char c) {
        for (int i = ca + 1; i < 12; i++) {
            if (map[i][cb] == '.') {
                map[ca][cb] = '.';
                map[i][cb] = c;
                ca = i;

            } else {
                break;
            }
        }
    }

    private boolean bfs(int a, int b, char c) {
        int cnt = 1;
        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> remember = new LinkedList<>();

        remember.add(new Pair(a, b));
        q.add(new Pair(a, b));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < 12 && nb < 6 && !visited[na][nb]) {
                    if (map[na][nb] == c) {
                        cnt++;
                        visited[na][nb] = true;

                        q.add(new Pair(na, nb));
                        remember.add(new Pair(na, nb));
                    }
                }
            }
        }

        if (cnt >= 4) {
            for (Pair p : remember) {
                map[p.getA()][p.getB()] = '.';
            }
            return true;
        }else return false;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
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