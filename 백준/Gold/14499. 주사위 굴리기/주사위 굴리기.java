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
    private int X;
    private int Y;
    private int K;
    private int[][] arr;
    private ArrayList<Integer> orders = new ArrayList<>();
    private int[] dice = {0, 0, 0, 0, 0, 0};

    public void solution() throws IOException {
        input();

        for (int dir : orders) {
            if (!isPossible(X, Y, dir)) continue;
            rollingDice(dir);
            changeNumOfBottom(X, Y);
            printTopOfDice();
        }
    }

    private void changeNumOfBottom(int a, int b) {
        if (arr[a][b] == 0) {
            arr[a][b] = dice[1];
        } else {
            dice[1] = arr[a][b];
            arr[a][b] = 0;
        }
    }

    private boolean isPossible(int a, int b, int dir) {
        int na = a;
        int nb = b;

        if (dir == 1) {
            nb = b + 1;
        } else if (dir == 2) {
            nb = b - 1;
        } else if (dir == 3) {
            na = a - 1;
        } else {
            na = a + 1;
        }

        if (na >= 0 && na < N && nb >= 0 && nb < M) {
            X = na;
            Y = nb;
            return true;
        } else {
            return false;
        }
    }

    private void rollingDice(int dir) {
        if (dir == 1) {
            int tmp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[0];
            dice[0] = tmp;

        } else if (dir == 2) {
            int tmp = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[0];
            dice[0] = tmp;

        } else if (dir == 3) {
            int tmp = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[0];
            dice[0] = tmp;

        } else {
            int tmp = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[0];
            dice[0] = tmp;
        }
    }

    private void printTopOfDice() {
        System.out.println(dice[0]);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        X = Integer.parseInt(line[2]);
        Y = Integer.parseInt(line[3]);
        K = Integer.parseInt(line[4]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().split(" ");
        for (String s : line) {
            orders.add(Integer.parseInt(s));
        }
    }
}
