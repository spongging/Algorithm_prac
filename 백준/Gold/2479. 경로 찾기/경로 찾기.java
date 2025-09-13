import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, K, start, target;

    private int[] parent;
    private final ArrayList<String> arr = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void solution() throws IOException {
        input();
        initGraph();
        bfs();
    }

    private void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer v = q.poll();

            if (target == v) {
                output(true);
                return;
            }

            for (int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = v;
                }
            }
        }

        output(false);
    }

    private void output(boolean flag){
        if (!flag) {
            System.out.println(-1);

        } else {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int cur = target; cur != -1; cur = parent[cur]) {
                tmp.add(cur);
            }

            Collections.reverse(tmp);

            for (int n : tmp) {
                System.out.print((n + 1) + " ");
            }
        }
    }

    private void initGraph() {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isPossible(i, j)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
    }

    private boolean isPossible(int i, int j) {
        int cnt = 0;
        String s1 = arr.get(i);
        String s2 = arr.get(j);

        for (int t = 0; t < K; t++) {
            if (s1.charAt(t) != s2.charAt(t)) {
                cnt++;
            }

            if (cnt > 1) {
                return false;
            }
        }

        return true;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken()) - 1;
        target = Integer.parseInt(st.nextToken()) - 1;

    }
}
