import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, K;
    private int answer = 0;

    private int[] numbers;
    private boolean[] visited;
    private final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();
        dfs(0);
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void dfs(int idx) {
        if (idx == N) {
            bfs();
            return;
        }

        visited[idx] = true;
        dfs(idx + 1);
        visited[idx] = false;
        dfs(idx + 1);
    }

    private void bfs() {
        if (!visited[0]) return;

        int apple = 0 ; int pear = 0; int total = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) continue;

            total++;
            if (numbers[i] == 1) {
                apple++;

            } else if (numbers[i] == 2) {
                pear++;
            }
        }

        if (apple > K) return;

        boolean[] visited2 = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        int tmpCnt = 1;

        q.add(0);
        visited2[0] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();

            for (int i = 0; i < tree.get(idx).size(); i++) {
                int newIdx = tree.get(idx).get(i);

                if (visited[newIdx] && !visited2[newIdx]) {
                    visited2[newIdx] = true;
                    tmpCnt++;
                    q.add(newIdx);
                }
            }
        }

        if (tmpCnt == total) {
            answer = Math.max(answer, pear);
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        for (int i = 0; i < N; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            line = br.readLine().split(" ");
            tree.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            tree.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
        }

        numbers = new int[N];
        visited = new boolean[N];

        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }
    }
}