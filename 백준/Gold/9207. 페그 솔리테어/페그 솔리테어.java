import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int answerRemainPin, answerMoveCnt, pin = 0;

    private char[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            inputAndInit();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 'o') {
                        dfs(i, j, pin, 0);
                    }
                }
            }

            output();
            T--;
        }
    }

    private void output() {
        System.out.println(answerRemainPin + " " + answerMoveCnt);
    }

    private void dfs(int a, int b, int tmpRemainPin, int tmpMoveCnt) {
        if (answerRemainPin >= tmpRemainPin) {
            answerRemainPin = tmpRemainPin;
            answerMoveCnt = tmpMoveCnt;
        }

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (checkRange(na, nb) && map[na][nb] == 'o') {
                int nna = na + da[i];
                int nnb = nb + db[i];

                if (checkRange(nna, nnb) && map[nna][nnb] == '.') {
                    map[a][b] = map[na][nb] = '.';
                    map[nna][nnb] = 'o';

                    for (int k = 0; k < 5; k++) {
                        for (int m = 0; m < 9; m++) {
                            if (map[k][m] == 'o') {
                                dfs(k, m, tmpRemainPin - 1, tmpMoveCnt + 1);
                            }
                        }
                    }

                    map[a][b] = map[na][nb] = 'o';
                    map[nna][nnb] = '.';
                }
            }
        }
    }

    private boolean checkRange(int a, int b) {
        return a >= 0 && b >= 0 && a < 5 && b < 9;
    }

    private void inputAndInit() throws IOException {
        pin = 0;
        answerRemainPin = answerMoveCnt = Integer.MAX_VALUE;

        map = new char[5][9];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();

            for (int j = 0; j < 9; j++) {
                char c = s.charAt(j);

                if (c=='o') pin++;
                map[i][j] = c;
            }
        }

        br.readLine();
    }
}