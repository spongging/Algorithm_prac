import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int[][] arr;
    private ArrayList<Pair> relationships = new ArrayList<>();

    public void solution() throws IOException {
        input();
        getRelationship();
        output(getMinCnt());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getMinCnt() {
        int min = Integer.MAX_VALUE;

        for (Pair p : relationships) {
            int tmp = 0;

            int a = p.getA();
            int b = p.getB();
            int c = p.getC();

            for (int i = 1; i <= N; i++) {
                if (arr[a][i] == 1) {
                    if (b != i && c != i) {
                        tmp++;
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (arr[b][i] == 1) {
                    if (a != i && c != i) {
                        tmp++;
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (arr[c][i] == 1) {
                    if (b != i && a != i) {
                        tmp++;
                    }
                }
            }

            min = Math.min(min, tmp);
        }

        if (min != Integer.MAX_VALUE) {
            return min;
        } else {
            return -1;
        }
    }

    private void getRelationship() {
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                if (arr[i][j] == 1) {
                    for (int k = j + 1; k <= N; k++) {
                        if (arr[j][k] == 1) {
                            if (arr[k][i] == 1) {
                                relationships.add(new Pair(i, j, k));
                            }
                        }
                    }
                }
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] line2 = br.readLine().split(" ");

            int n1 = Integer.parseInt(line2[0]);
            int n2 = Integer.parseInt(line2[1]);

            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }
    }
}

class Pair {
    private int a;
    private int b;
    private int c;

    public Pair(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
}





