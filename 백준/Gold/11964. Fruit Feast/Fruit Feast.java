import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, A, B;

    public void solution() throws IOException {
        input();
        output(bfs());
    }

    private int bfs() {
        int answer = 0;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[T + 1][2];

        visited[0][0] = true;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int cost = p.getCost();
            int isDrank = p.getIsDrank();

            if (cost==T) return cost;
            if (cost < T) {
                answer = Math.max(answer, cost);
            }

            for (int i = 0; i < 3; i++) {
                int tmpCost = cost;

                if (i == 0) {
                    tmpCost += A;

                    if (tmpCost <= T && !visited[tmpCost][isDrank]) {
                        visited[tmpCost][isDrank] = true;
                        q.add(new Pair(tmpCost, isDrank));
                    }

                } else if (i == 1) {
                    tmpCost += B;

                    if (tmpCost <= T &&!visited[tmpCost][isDrank]) {
                        visited[tmpCost][isDrank] = true;
                        q.add(new Pair(tmpCost, isDrank));
                    }

                } else {
                    tmpCost /= 2;

                    if (isDrank == 0) {
                        if (tmpCost>T) continue;

                        if (!visited[tmpCost][1]) {
                            visited[tmpCost][1] = true;
                            q.add(new Pair(tmpCost, 1));
                        }
                    }
                }
            }
        }

        return answer;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        T = Integer.parseInt(line[0]);
        A = Integer.parseInt(line[1]);
        B = Integer.parseInt(line[2]);
    }
}

class Pair {
    private final int cost;
    private final int isDrank;

    public Pair(int cost, int isDrank) {
        this.cost = cost;
        this.isDrank = isDrank;
    }

    public int getCost() {
        return cost;
    }

    public int getIsDrank() {
        return isDrank;
    }
}