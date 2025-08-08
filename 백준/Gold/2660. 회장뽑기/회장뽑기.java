import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, tmpMaxLevel, answerLevel = Integer.MAX_VALUE;

    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private final ArrayList<Integer> answerArr = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 1; i <= N; i++) {
            tmpMaxLevel = 0;
            bfs(i);

            if (tmpMaxLevel < answerLevel) {
                answerLevel = tmpMaxLevel;
                answerArr.clear();
                answerArr.add(i);
            } else if (tmpMaxLevel == answerLevel) {
                answerArr.add(i);
            }
        }

        output();
    }

    private void bfs(int vertex) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(new Pair(vertex, 0));
        visited[vertex] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int v = p.getV();
            int cnt = p.getCnt();

            if (cnt > tmpMaxLevel) {
                tmpMaxLevel = cnt;
            }

            for (int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, cnt + 1));
                }
            }
        }
    }

    private void output() {
        System.out.println(answerLevel + " " + answerArr.size());

        for (int n : answerArr) {
            System.out.print(n + " ");
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        String[] line;
        while (true) {
            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            if (a == -1 && b == -1) break;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

    }
}

class Pair {
    private final int v;
    private final int cnt;

    public Pair(int v, int cnt) {
        this.v = v;
        this.cnt = cnt;
    }

    public int getV() {
        return v;
    }

    public int getCnt() {
        return cnt;
    }
}