import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, H;
    private int[][] arr;
    private int targetA, targetB;
    private int answer = 0;
    private boolean[] visited;
    private ArrayList<Pair> milks = new ArrayList<>();

    public void solution() throws IOException {
        input();
        backTracking(targetA, targetB, 0, M);
        output();
    }

    private void backTracking(int a, int b, int level, int hp) {
        if (check(targetA, targetB, a, b, hp)) { //집에 갈 수 있는지
            answer = Math.max(level, answer);
        }

        if (level == milks.size()) {
            return;
        }

        for (int i = 0; i < milks.size(); i++) {
            if (!visited[i]) {
                Pair p = milks.get(i);
                int dis = Math.abs(p.getA() - a) + Math.abs(p.getB() - b);

                if (check(p.getA(), p.getB(), a, b, hp)) {
                    visited[i] = true;
                    backTracking(p.getA(), p.getB(), level + 1, hp - dis + H);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean check(int a1, int b1, int a2, int b2, int hp) {
        return Math.abs(a1 - a2) + Math.abs(b1 - b2) <= hp;
    }

    private void output() {
        System.out.println(answer);
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        H = Integer.parseInt(line[2]);

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(line2[j]);

                if (num == 1) {
                    targetA = i;
                    targetB = j;
                } else if (num == 2) {
                    milks.add(new Pair(i, j));
                }

                arr[i][j] = num;
            }
        }

        visited = new boolean[milks.size()];
    }
}

class Pair {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}