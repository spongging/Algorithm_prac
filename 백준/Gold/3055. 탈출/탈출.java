import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int R, C, targetA, targetB;
    private int time = 0;

    private final ArrayList<Pair> waterDir = new ArrayList<>();
    private final ArrayList<Pair> hedgehogDir = new ArrayList<>();
    private final int[] da = {0, 0, -1, 1};
    private final int[] db = {1, -1, 0, 0};
    private boolean[][] waterVisited;
    private boolean[][] hedgehogVisited;
    private char[][] map;

    public void solution() throws IOException {
        input();

        while (true) {
            int wSize = waterDir.size();
            int hSize = hedgehogDir.size();

            time++;

            for (int i = 0; i < wSize; i++) {
                Pair water = waterDir.get(0);
                waterDir.remove(0);
                movingWater(water.getA(), water.getB());
            }

            if (hedgehogDir.isEmpty()) {
                System.out.println("KAKTUS");
                System.exit(0);
            }

            for (int i = 0; i < hSize; i++) {
                Pair hedgehog = hedgehogDir.get(0);
                hedgehogDir.remove(0);

                if (hedgehog.getA() == targetA && hedgehog.getB() == targetB) {
                    System.out.println(time - 1);
                    System.exit(0);
                }

                movingHedgehog(hedgehog.getA(), hedgehog.getB());
            }
        }
    }

    private void movingHedgehog(int a, int b) {
        hedgehogVisited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && nb >= 0 && na < R && nb < C && !hedgehogVisited[na][nb]) {
                if (map[na][nb] == '.' || map[na][nb] == 'D') {
                    hedgehogDir.add(new Pair(na, nb));
                    hedgehogVisited[na][nb] = true;
                }
            }
        }

    }

    private void movingWater(int a, int b) {
        waterVisited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && nb >= 0 && na < R && nb < C && !waterVisited[na][nb]) {
                if (map[na][nb]=='D' || map[na][nb]=='X') continue;
                
                waterDir.add(new Pair(na, nb));
                waterVisited[na][nb] = true;
                map[na][nb] = '*';
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        map = new char[R][C];
        waterVisited = new boolean[R][C];
        hedgehogVisited = new boolean[R][C];

        for (int i = 0; i < R ; i++){
            String s = br.readLine();

            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);

                if (c == 'S') {
                    hedgehogDir.add(new Pair(i, j));
                } else if (c == 'D') {
                    targetA = i;
                    targetB = j;

                } else if (c == '*') {
                    waterDir.add(new Pair(i, j));
                }

                map[i][j] = c;
            }
        }
    }
}

class Pair{
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
