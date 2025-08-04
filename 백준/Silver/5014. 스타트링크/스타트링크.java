import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int F,S,G,U, D;

    public void solution() throws IOException {
        input();
        output(getAnswer());
    }

    private int getAnswer() {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        int[] ds = {U, -D};

        q.add(new Pair(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int tmpLevel = p.getLevel();
            int tmpCnt = p.getCnt();

            if (tmpLevel == G) {
                return tmpCnt;
            }

            for (int i = 0; i < 2; i++) {
                int next = tmpLevel + ds[i];

                if (next > 0 && next <= F && !visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, tmpCnt + 1));
                }
            }

        }

        return -1;
    }

    private void output(int answer) {
        if (answer == -1) {
            System.out.println("use the stairs");
        }else System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        F = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        G = Integer.parseInt(line[2]);
        U = Integer.parseInt(line[3]);
        D = Integer.parseInt(line[4]);
    }
}

class Pair {
    private final int level;
    private final int cnt;

    public Pair(int level, int cnt) {
        this.level = level;
        this.cnt = cnt;
    }

    public int getLevel() {
        return level;
    }

    public int getCnt() {
        return cnt;
    }
}