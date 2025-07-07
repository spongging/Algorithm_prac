import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int n;
    private boolean isCondition2 = true;

    private char[][] map;
    private boolean[][] visited;
    private ArrayList<Pair> bulbs = new ArrayList<>();
    private ArrayList<Pair> numbers = new ArrayList<>();
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        inputAndInit();

        for (Pair p : bulbs) {
            lightUp(p.getA(), p.getB());
        }

        if (!isCondition2) {
            output(0);
            return;
        }

        if (!checkCondition1()) {
            output(0);
            return;
        }

        if (!checkCondition3()) {
            output(0);
            return;
        }

        output(1);
    }

    private boolean checkCondition3() {
        for (Pair p : numbers) {
            int num = map[p.getA()][p.getB()] - '0';

            int a = p.getA();
            int b = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = a + da[i];
                int nb = b + db[i];

                if (na >= 0 && nb >= 0 && na < n && nb < n && map[na][nb] == '?') {
                    num--;
                }
            }

            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCondition1() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.' && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void lightUp(int a, int b) {
        int na, nb;

        for (int i = 1; i < n; i++) {
            na = a - i;
            nb = b;

            if (!checkAndSpreadIfPossible(na, nb)) {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            na = a;
            nb = b + i;

            if (!checkAndSpreadIfPossible(na, nb)) {
                break;
            }        }

        for (int i = 1; i < n; i++) {
            na = a + i;
            nb = b;

            if (!checkAndSpreadIfPossible(na, nb)) {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            na = a;
            nb = b - i;

            if (!checkAndSpreadIfPossible(na, nb)) {
                break;
            }
        }
    }

    private boolean checkAndSpreadIfPossible(int na, int nb) {
        if (na >= 0 && nb >= 0 && na < n && nb < n && map[na][nb] != '.') {
            if (map[na][nb] == '?') {
                isCondition2 = false;
            }
            return false;
        }

        if (na >= 0 && nb >= 0 && na < n && nb < n && map[na][nb] == '.') {
            if (!visited[na][nb]) {
                visited[na][nb] = true;
            }
        }

        return true;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);

                if (c == '?') {
                    bulbs.add(new Pair(i, j));
                } else if (c >= '0' && c <= '4') {
                    numbers.add(new Pair(i, j));
                }

                map[i][j] = c;
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