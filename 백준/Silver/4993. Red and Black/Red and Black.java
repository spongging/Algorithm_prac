import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int W, H;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private char[][] map;
    private int initA, initB;
    private int maxCnt;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private boolean[][] visited;

    public void solution() throws IOException {
        while (true) {
            input();

            if (W == 0 && H == 0) {
                break;
            }

            visited[initA][initB] = true;
            dfs(initA, initB);

            output();
        }
    }

    private void output() {
        System.out.println(maxCnt);
    }

    private void dfs(int a, int b) {
        maxCnt++;

        for (int i = 0; i < 4; i++) {
            int na = da[i] + a;
            int nb = db[i] + b;

            if (na >= 0 && nb >= 0 && na < H && nb < W && !visited[na][nb]) {
                if (map[na][nb] == '.') {
                    visited[na][nb] = true;
                    dfs(na, nb);
                }
            }
        }

    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        W = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]);

        if (W == 0 && H == 0) {
            return;
        }

        map = new char[H][W];
        visited = new boolean[H][W];
        maxCnt = 0;

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = s.charAt(j);

                if (c == '@') {
                    initA = i;
                    initB = j;
                }

                map[i][j] = c;
            }
        }
    }
}