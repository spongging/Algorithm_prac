import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private char[][] arr = new char[5][9];
    private ArrayList<Pair> pairs = new ArrayList<>();
    private ArrayList<Character> missing = new ArrayList<>();
    private boolean[] alpha = new boolean[12];
    private boolean[] visited;
    private char[][] tmpArr;
    private boolean flag = false;

    public void solution() throws IOException {
        input();
        findingMissing();
        backtracking(0, "");
        output();
    }

    private void output() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tmpArr[i][j]);
            }
            System.out.println();
        }
    }

    private void backtracking(int level, String s) {
        if (flag) {
            return;
        }

        if (level == missing.size()) {
            merge(s);
            if (calculate()) {
                flag = true;
            }

            return;
        }

        for (int i = 0; i < missing.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(level + 1, s + missing.get(i));
                visited[i] = false;
            }
        }
    }

    private void merge(String s) {
        tmpArr = new char[5][9];
        for (int i = 0; i < 5; i++) {
            System.arraycopy(arr[i], 0, tmpArr[i], 0, 9);
        }

        int idx = 0;

        for (Pair p : pairs) {
            tmpArr[p.getA()][p.getB()] = s.charAt(idx);
            idx++;
        }
    }

    private boolean calculate() {
        if ((tmpArr[0][4] - 'A') + (tmpArr[1][3] - 'A') + (tmpArr[2][2] - 'A') + (tmpArr[3][1] - 'A') + 4 != 26) {
            return false;
        }

        if ((tmpArr[0][4] - 'A') + (tmpArr[1][5] - 'A') + (tmpArr[2][6] - 'A') + (tmpArr[3][7] - 'A') + 4 != 26) {
            return false;
        }

        if ((tmpArr[1][1] - 'A') + (tmpArr[1][3] - 'A') + (tmpArr[1][5] - 'A') + (tmpArr[1][7] - 'A') + 4 != 26) {
            return false;
        }

        if ((tmpArr[1][1] - 'A') + (tmpArr[2][2] - 'A') + (tmpArr[3][3] - 'A') + (tmpArr[4][4] - 'A') + 4 != 26) {
            return false;
        }

        if ((tmpArr[1][7] - 'A') + (tmpArr[2][6] - 'A') + (tmpArr[3][5] - 'A') + (tmpArr[4][4] - 'A') + 4 != 26) {
            return false;
        }

        return (tmpArr[3][1] - 'A') + (tmpArr[3][3] - 'A') + (tmpArr[3][5] - 'A') + (tmpArr[3][7] - 'A') + 4 == 26;
    }

    private void findingMissing() {
        for (int i = 0; i < 12; i++) {
            if (!alpha[i]) {
                missing.add((char) (i + 'A'));
            }
        }

        visited = new boolean[missing.size()];
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < line.length; j++) {
                char c = line[j].charAt(0);
                arr[i][j] = c;

                if (c == 'x') {
                    pairs.add(new Pair(i, j));
                } else if (c != '.') {
                    alpha[c - 'A'] = true;
                }
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
