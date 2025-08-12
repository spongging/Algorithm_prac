import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int R, C, K;
    private int curDir, curA, curB;
    private int dirIdx = 0;

    private char[][] map;
    private boolean[][] visited;
    private final int[] da = {-1, 1, 0, 0}; // 위 아 좌 오
    private final int[] db = {0, 0, -1, 1};
    private final ArrayList<Integer> orders = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();

        while (true) {
            boolean flag = false;

            if (isPossible(curA, curB, curDir)) {
                curA += da[curDir];
                curB += db[curDir];
                visited[curA][curB] = true;

                flag = true;

            } else {
                for (int i = 0; i < 3; i++) {
                    changeDir();

                    if (isPossible(curA, curB, curDir)) {
                        curA += da[curDir];
                        curB += db[curDir];
                        visited[curA][curB] = true;

                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                output();
                break;
            }
        }
    }

    private void output() {
        System.out.println(curA + " " + curB);
    }

    private void changeDir() {
        curDir = orders.get((++dirIdx) % 4);
    }

    private boolean isPossible(int a, int b, int curDir) {
        int na = a + da[curDir];
        int nb = b + db[curDir];

        return na >= 0 && nb >= 0 && na < R && nb < C && !visited[na][nb] && map[na][nb] == '*';
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        K = Integer.parseInt(br.readLine().trim());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = '*';
            }
        }

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 'X';
        }

        line = br.readLine().split(" ");
        map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 'O';
        visited[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
        curA = Integer.parseInt(line[0]);
        curB = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        for (String s : line) {
            orders.add(Integer.parseInt(s) - 1);
        }

        curDir = orders.get(0);
    }
}