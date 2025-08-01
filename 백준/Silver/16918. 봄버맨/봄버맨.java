import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int R, C, N;
    private int time = 1;

    private char[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private final ArrayList<Pair> arr = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();

        if (N == 1) {
            output();
            return;
        }

        while (true) {
            time++;
            plantingBomb();

            if (check()) {
                output();
                break;
            }

            time++;
            destroy();

            if (check()) {
                output();
                break;
            }

            saving();
        }
    }

    private void saving() {
        arr.clear();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    arr.add(new Pair(i, j));
                }
            }
        }
    }

    private boolean check() {
        return time == N;
    }

    private void destroy() {
        for (Pair p : arr) {
            int aa = p.getA();
            int bb = p.getB();

            map[aa][bb] = '.';

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < R && nb < C) {
                    map[na][nb] = '.';
                }
            }
        }
    }

    private void plantingBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                }
            }
        }
    }

    private void output() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        N = Integer.parseInt(line[2]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (s.charAt(j) == 'O') {
                    arr.add(new Pair(i, j));
                }
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