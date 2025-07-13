import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int n, answer;

    private char[][] map;
    private char[] arr;
    private ArrayList<Integer> rooksIdx;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (inputAndInit()) {
            putRooks(0,0);
            output();
        }
    }

    private void output() {
        System.out.println(answer);
    }

    private void putRooks(int idx, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = idx; i < n * n; i++) {
            if (arr[i] != 'X') {
                rooksIdx.add(i);
                map[i / n][i % n] = 'O';

                if (isPossible()) {
                    putRooks(i + 1, cnt + 1);
                }

                rooksIdx.remove(rooksIdx.size() - 1);
                map[i / n][i % n] = '.';
            }
        }
    }

    private boolean isPossible() {
        ArrayList<Pair> rookCoords = new ArrayList<>();

        for (int idx : rooksIdx) {
            rookCoords.add(new Pair(idx / n, idx % n));
        }

        for (Pair p : rookCoords) {
            int a = p.getA();
            int b = p.getB();

            for (int i = 1; i < n; i++) { // right
                int nb = b + i;

                if (a < 0 || nb < 0 || a >= n || nb >= n) {
                    break;
                }

                if (map[a][nb]=='X') {
                    break;
                } else if (map[a][nb] == 'O') {
                    return false;
                }
            }

            for (int i = 1; i < n; i++) { // down
                int na = a + i;

                if (na < 0 || b < 0 || na >= n || b >= n) {
                    break;
                }

                if (map[na][b]=='X') {
                    break;
                } else if (map[na][b] == 'O') {
                    return false;
                }
            }

            for (int i = 1; i < n; i++) { // left
                int nb = b - i;

                if (a < 0 || nb < 0 || a >= n || nb >= n) {
                    break;
                }

                if (map[a][nb]=='X') {
                    break;
                } else if (map[a][nb] == 'O') {
                    return false;
                }
            }

            for (int i = 1; i < n; i++) { // up
                int na = a - i;

                if (na < 0 || b < 0 || na >= n || b >= n) {
                    break;
                }

                if (map[na][b]=='X') {
                    break;
                } else if (map[na][b] == 'O') {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean inputAndInit() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) break;
        }
        if (line == null) return false;

        n = Integer.parseInt(line);

        if (n == 0) {
            return false;
        }

        answer = 0;
        map = new char[n][n];
        arr = new char[n * n];
        rooksIdx = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {
            String row;
            while ((row = br.readLine()) != null && row.trim().isEmpty()) { }
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
                arr[idx++] = row.charAt(j);
            }
        }

        return true;
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