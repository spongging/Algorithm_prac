import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private int answer;
    private boolean isFounded;
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private final ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    private final ArrayList<Query> queries = new ArrayList<>();
    private boolean[] visited;

    public void solution() throws IOException {
        inputAndInit();

        for (Query q : queries) {
            answer = 0;
            isFounded = false;

            visited[q.getSt()] = true;
            dfs(q.getSt(), q.getEd(), 0);
            visited[q.getSt()] = false;

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    private void dfs(int vertex, int target, int weight) {
        if (isFounded) return;

        if (vertex == target) {
            answer = weight;
            isFounded = true;
            return;
        }

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int next = graph.get(vertex).get(i).getV();
            int cost = graph.get(vertex).get(i).getCost();

            if (!visited[next]) {
                visited[next] = true;
                dfs(next, target, weight + cost);
                visited[next] = false;
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
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new Pair(n2, cost));
            graph.get(n2).add(new Pair(n1, cost));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queries.add(new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
}

class Query {
    private final int st;
    private final int ed;

    public Query(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }

    public int getSt() {
        return st;
    }

    public int getEd() {
        return ed;
    }
}

class Pair {
    private final int v;
    private final int cost;

    public Pair(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    public int getV() {
        return v;
    }

    public int getCost() {
        return cost;
    }
}