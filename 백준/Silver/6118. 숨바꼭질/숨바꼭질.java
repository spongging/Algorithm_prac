import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int answerCnt;
    private int answerMax = -1;

    private final ArrayList<Integer> answerArr = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private int[] dist;

    public void solution() throws IOException {
        inputAndInit();
        bfs();
        getAnswer();
        output();
    }

    private void output() {
        System.out.print(answerArr.get(0) + " " + answerMax + " " + answerCnt);
    }

    private void getAnswer() {
        for (int i = 1; i <= N; i++) {
            if (answerMax < dist[i]) {
                answerMax = dist[i];
                answerArr.clear();
                answerArr.add(i);
                answerCnt = 1;

            } else if (answerMax == dist[i]) {
                answerArr.add(i);
                answerCnt++;
            }
        }
    }

    private void bfs(){
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[1] = true;
        q.add(new Pair(1, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int v = p.getV();
            int cnt = p.getCnt();

            for (int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, cnt + 1));
                    dist[next] = cnt + 1;
                }
            }
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        dist[1] = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
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