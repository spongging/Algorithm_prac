import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int K;
    private char[][] arr;
    private boolean flag = false;

    public void solution() throws IOException {
        input();
        bfs();
        output();
    }

    private void output() {
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private void bfs() {
        boolean[][] visited = new boolean[2][N];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int aa = p.getA();
            int bb = p.getB();
            int time = p.getTime();
            int na = aa, nb = bb;

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nb = bb + 1;
                } else if (i == 1) {
                    nb = bb - 1;
                } else {
                    if (aa == 0) {
                        na = 1;
                        nb = bb + K;
                    } else {
                        na = 0;
                        nb = bb + K;
                    }
                }

                if (nb >= N) {
                    flag = true;
                    break;
                }

                if (nb >= 0 && arr[na][nb] == '1' && nb > time && !visited[na][nb]) {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb, time + 1));
                }
            }
        }
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line2 = br.readLine().split(" ");
        N = Integer.parseInt(line2[0]);
        K = Integer.parseInt(line2[1]);

        arr = new char[2][N];

        for (int i = 0; i < 2; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
    }
}

class Pair{
    private int a;
    private int b;
    private int time;

    public Pair(int a, int b, int time) {
        this.a = a;
        this.b = b;
        this.time = time;
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
}