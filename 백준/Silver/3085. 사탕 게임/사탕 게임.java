import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int answer = 0;

    private char[][] map;

    public void solution() throws IOException {
        input();
        answer = getContinueMax();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //up swap
                if (i - 1 >= 0) {
                    swap(i, j, i - 1, j);
                    answer = Math.max(answer, getContinueMax());
                    undo(i, j, i - 1, j);
                }

                //right
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, getContinueMax());
                    undo(i, j, i, j + 1);
                }

                //left
                if (j - 1 >= 0) {
                    swap(i, j, i, j - 1);
                    answer = Math.max(answer, getContinueMax());
                    undo(i, j, i, j - 1);
                }

                //down
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, getContinueMax());
                    undo(i, j, i + 1, j);
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void undo(int a1, int b1, int a2, int b2) {
        char tmp = map[a1][b1];
        map[a1][b1] = map[a2][b2];
        map[a2][b2] = tmp;
    }

    private void swap(int a1, int b1, int a2, int b2) {
        char tmp = map[a1][b1];
        map[a1][b1] = map[a2][b2];
        map[a2][b2] = tmp;
    }

    private int getContinueMax() {
        int maxColumn = 1;
        int maxRow = 1;
        char c1, c2;

        // 행
        for (int i = 0; i < N; i++) {
            c1 = map[i][0];
            int tmp = 1;

            for (int j = 1; j < N; j++) {
                if (c1 != map[i][j]) {
                    c1 = map[i][j];
                    maxRow = Math.max(tmp, maxRow);
                    tmp = 1;

                } else {
                    tmp++;
                }
            }

            maxRow = Math.max(tmp, maxRow);

        }

        //열
        for (int i = 0; i < N; i++) {
            c2 = map[0][i];
            int tmp = 1;

            for (int j = 1; j < N; j++) {
                if (c2 != map[j][i]) {
                    c2 = map[j][i];
                    maxColumn = Math.max(tmp, maxColumn);
                    tmp = 1;

                } else {
                    tmp++;
                }
            }
            maxColumn = Math.max(tmp, maxColumn);
        }

        return Math.max(maxRow, maxColumn);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
    }
}