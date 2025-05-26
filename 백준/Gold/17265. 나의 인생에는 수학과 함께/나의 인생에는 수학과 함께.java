import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int minAnswer = Integer.MAX_VALUE;
    private int maxAnswer = Integer.MIN_VALUE;

    private char[][] arr;
    private final int[] da = {0, 1}; // right, down
    private final int[] db = {1, 0};
    private boolean[][] visited;

    public void solution() throws IOException {
        input();
        dfs(0, 0, "" + arr[0][0]);
        output();
    }

    private void dfs(int a, int b, String s) {

        if (a == N - 1 && b == N - 1) {
            int tmpResult = cal(s);

            comparing(tmpResult);

            return;
        }

        for (int i = 0; i < 2; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && na < N && nb >= 0 && nb < N) {
                if (!visited[na][nb]) {
                    visited[na][nb] = true;
                    dfs(na, nb, s + arr[na][nb]);
                    visited[na][nb] = false;
                }
            }
        }
    }

    private void comparing(int num) {
        maxAnswer = Math.max(maxAnswer, num);
        minAnswer = Math.min(minAnswer, num);
    }

    private void output() {
        System.out.println(maxAnswer + " " + minAnswer);
    }

    private int cal(String s) {
        int result = 0;
        int idx = 0;
        int num = 0;

        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            num = num * 10 + (s.charAt(idx++) - '0');
        }

        result += num;

        while (idx < s.length()) {
            char oper = s.charAt(idx++);
            int nextNum = 0;

            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                nextNum = nextNum * 10 + (s.charAt(idx++) - '0');
            }

            switch (oper) {
                case '+':
                    result += nextNum;
                    break;
                case '*':
                    result *= nextNum;
                    break;
                case '-':
                    result -= nextNum;
                    break;
            }
        }

        return result;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = line[j].charAt(0);
            }
        }
    }
}









