import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int cntO;
    private int cntX;

    private char[][] map;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        while (n > 0) {
            input();
            counting();
            output(isPossible());
            n--;
            if (n > 0) br.readLine();
        }
    }

    private boolean isPossible() {
        if (cntO > cntX) return false;
        if (cntX>cntO+1) return false;
        if (cntO == cntX) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 'X') {
                        if (isWin(i, j, 'X')) {
                            return false;
                        }
                    }
                }
            }
        }
        if (cntX == cntO + 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 'O') {
                        if (isWin(i, j, 'O')) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean isWin(int a, int b ,char c) {
        int cnt = 1;
        int na, nb;

        for (int i = 1; i < 3; i++) {
            na = a - i;
            nb = b;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 && map[na][nb] == c) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a - i;
            nb = b + i;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 &&map[na][nb] == c) {
                cnt++;
            }else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a;
            nb = b + i;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 &&map[na][nb] == c) {
                cnt++;
            } else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a + i;
            nb = b + i;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 &&map[na][nb] == c) {
                cnt++;
            }else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a + i;
            nb = b;

            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 && map[na][nb] == c) {
                cnt++;
            }else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a + i;
            nb = b - i;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 && map[na][nb] == c) {
                cnt++;
            } else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a;
            nb = b - i;

            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 && map[na][nb] == c) {
                cnt++;
            }else break;
        }

        if (cnt==3) return true;

        cnt = 1;
        for (int i = 1; i < 3; i++) {
            na = a - i;
            nb = b - i;
            if (na >= 0 && nb >= 0 && na < 3 && nb < 3 && map[na][nb] == c) {
                cnt++;
            } else break;
        }

        return false;
    }


    private void output(boolean isPossible) {
        if (isPossible) {
            System.out.println("yes");
        } else System.out.println("no");
    }

    private void counting() {
        cntX = 0; cntO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'X') {
                    cntX++;

                } else if (map[i][j] == 'O') {
                    cntO++;
                }
            }
        }
    }

    private void input() throws IOException {
        map = new char[3][3];

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();

            for (int j = 0; j < 3; j++) {
                map[i][j] = s.charAt(j);
            }
        }
    }
}