import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int M;
    private int R;
    private int C;
    private int dir = 0; // 0 북, 1 동, 2 남, 3 서
    private int[][] arr;
    private int answer = 0;
    private int[] dR = {0, 0, -1, 1};
    private int[] dC = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();

        while (R >= 0 && R < N && C >= 0 && C < M && arr[R][C] != 1) {

            if (arr[R][C] == 0) {
                cleaning(R, C);
            }

            if (isNonCleaningExist(R, C)) {
                findNonCleaningAndForward(R, C, dir);
            } else {
                goBack(R, C, dir);
            }

        }

        output();
    }

    private void findNonCleaningAndForward(int curR, int curC, int curDir) {
        while (true) {
            curDir = (curDir + 3) % 4;

            if (curDir == 0) {
                int newR = curR - 1;
                if (newR >= 0 && newR < N && curC >= 0 && curC < M && arr[newR][curC] == 0) {
                    R = newR;
                    dir = curDir;
                    break;
                }

            } else if (curDir == 1) {
                int newC = curC + 1;
                if (curR >= 0 && curR < N && newC >= 0 && newC < M && arr[curR][newC] == 0) {
                    C = newC;
                    dir = curDir;
                    break;
                }

            } else if (curDir == 2) {
                int newR = curR + 1;
                if (newR >= 0 && newR < N && curC >= 0 && curC < M && arr[newR][curC] == 0) {
                    R = newR;
                    dir = curDir;
                    break;
                }
            } else {
                int newC = curC - 1;
                if (curR >= 0 && curR < N && newC >= 0 && newC < M && arr[curR][newC] == 0) {
                    C = newC;
                    dir = curDir;
                    break;
                }
            }
        }
    }

    private void goBack(int curR, int curC, int curDir) {
        if (curDir == 0) {
            R = curR + 1;
        } else if (curDir == 1) {
            C = curC - 1;
        } else if (curDir == 2) {
            R = curR - 1;
        } else {
            C = curC + 1;
        }
    }

    private boolean isNonCleaningExist(int curR, int curC) {
        for (int i = 0; i < 4; i++) {
            int newR = curR + dR[i];
            int newC = curC + dC[i];

            if (newR >= 0 && newR < N && newC >= 0 && newC < M && arr[newR][newC] == 0) {
                return true;
            }
        }

        return false;
    }

    private void cleaning(int curR, int curC) {
        arr[curR][curC] = 2;
        answer++;
    }

    private void output() {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        String[] line2 = br.readLine().split(" ");
        R = Integer.parseInt(line2[0]);
        C = Integer.parseInt(line2[1]);
        dir = Integer.parseInt(line2[2]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line3 = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line3[j]);
            }
        }
    }
}


