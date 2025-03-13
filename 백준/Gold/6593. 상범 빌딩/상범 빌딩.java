import javax.swing.*;
import java.io.*;
import java.net.Inet4Address;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int L, R, C;
    private char[][][] arr;
    private int stA, stB, stC;
    private int targetA, targetB, targetC;
    private int answer;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (true) {
            if (!input()) break;
            bfs(stA, stB, stC);
            output();
        }
    }

    private void output() {
        if (answer == -1) {
            System.out.println("Trapped!");
        } else {
            System.out.println("Escaped in "+answer+" minute(s).");
        }
    }


    private void bfs(int stA, int stB, int stC) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        int[] dA = {0, 0, 0, 0, 1, -1};
        int[] dB = {1, -1, 0, 0, 0, 0};
        int[] dC = {0, 0, 1, -1, 0, 0};

        q.add(new Pair(stA, stB, stC, 0));
        visited[stA][stB][stC] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int aa = p.getA();
            int bb = p.getB();
            int cc = p.getC();
            int cnt = p.getCnt();

            if (isMatch(aa, bb, cc)) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int na = aa + dA[i];
                int nb = bb + dB[i];
                int nc = cc + dC[i];

                if (cordCheck(na, nb, nc, visited)) {
                    visited[na][nb][nc] = true;
                    q.add(new Pair(na, nb, nc, cnt + 1));
                }
            }
        }
    }

    private boolean isMatch(int a, int b, int c) {
        return a == targetA && b == targetB && c == targetC;
    }

    private boolean cordCheck(int a, int b, int c, boolean[][][] visited) {
        return a >= 0 && a < L && b >= 0 && b < R && c >= 0 && c < C && !visited[a][b][c] && arr[a][b][c]!='#';
    }

    private boolean input() throws IOException {
        String[] line = br.readLine().split(" ");

        L = Integer.parseInt(line[0]);
        R = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);

        answer = -1;

        if (L == 0 && R == 0 && C == 0) return false;

        arr = new char[L][R][C];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String s = br.readLine();
                for (int k = 0; k < C; k++) {
                    arr[i][j][k] = s.charAt(k);

                    if (s.charAt(k) == 'S') {
                        stA = i;
                        stB = j;
                        stC = k;

                    } else if (s.charAt(k) == 'E') {
                        targetA = i;
                        targetB = j;
                        targetC = k;
                    }
                }
            }

            br.readLine();
        }

        return true;
    }
}

class Pair {
    private int a;
    private int b;
    private int c;
    private int cnt;

    public Pair(int a, int b, int c, int cnt) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.cnt = cnt;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getCnt() {
        return cnt;
    }
}