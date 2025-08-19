import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T = 4;
    private boolean isPossible = false;

    private final ArrayList<String[]> arr = new ArrayList<>();
    private final ArrayList<Integer> answers = new ArrayList<>();
    private int[][] board;

    public void solution() throws IOException {
        input();

            for (String[] line : arr) {
                isPossible = false;
                init(line);

                if (!check()) {
                    answers.add(0);
                    continue;
                }

                backTracking(0, 1);

                if (isPossible) {
                    answers.add(1);
                } else answers.add(0);
            }


        output();
    }

    private void output() {
        for (int n : answers) {
            System.out.print(n + " ");
        }
    }

    private boolean check() {
        for (int i = 0; i < 6; i++) {
            if (board[i][0] + board[i][1] + board[i][2] != 5) {
                return false;
            }
        }

        return true;
    }

    private void backTracking(int cur, int next) {
        if (isPossible) return;

        if (cur == 5) {
            isPossible = true;
            return;
        }

        // 승
        if (board[cur][0] > 0 && board[next][2] > 0) {
            board[cur][0]--;
            board[next][2]--;

            if (next == 5) {
                backTracking(cur + 1, cur + 2);
            } else {
                backTracking(cur, next + 1);
            }

            board[cur][0]++;
            board[next][2]++;
        }

        // 무
        if (board[cur][1] > 0 && board[next][1] > 0) {
            board[cur][1]--;
            board[next][1]--;

            if (next == 5) {
                backTracking(cur + 1, cur + 2);
            } else {
                backTracking(cur, next + 1);
            }

            board[cur][1]++;
            board[next][1]++;
        }

        // 패
        if (board[cur][2] > 0 && board[next][0] > 0) {
            board[cur][2]--;
            board[next][0]--;

            if (next == 5) {
                backTracking(cur + 1, cur + 2);
            } else {
                backTracking(cur, next + 1);
            }

            board[cur][2]++;
            board[next][0]++;
        }
    }

    private void init(String[] line) {
        board = new int[6][3];

        for (int i = 0; i < line.length; i++) {
            board[i / 3][i % 3] = Integer.parseInt(line[i]);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] line = br.readLine().split(" ");
            arr.add(line);
        }
    }
}