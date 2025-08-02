import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private int[][] map;
    private final ArrayList<Pair> blacks = new ArrayList<>();
    private final ArrayList<Pair> whites = new ArrayList<>();

    public void solution() throws IOException {
        input();

        for (Pair bp : blacks) {
            int minDis = Integer.MAX_VALUE;

            for (Pair wp : whites) {
                minDis = Math.min(minDis, getDistance(bp.getA(), bp.getB(), wp.getA(), wp.getB()));
            }

            map[bp.getA() - 1][bp.getB() - 1] = minDis;
        }

        for (Pair wp : whites) {
            map[wp.getA() - 1][wp.getB() - 1] = 0;
        }

        output();
    }

    private void output() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getDistance(int a1, int b1, int a2, int b2) {
        return Math.abs(a1 - a2) + Math.abs(b1 - b2);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();

            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);

                if (c == '0') {
                    blacks.add(new Pair(i + 1, j + 1));
                } else whites.add(new Pair(i + 1, j + 1));

                map[i][j] = c;
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