import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, N, M;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<ArrayList<Integer>> map;
    private boolean[] visited;
    private int[] colors;

    public void solution() throws IOException {
        inputT();

        while (T > 0) {
            input();

            if (isPossible()) {
                output("possible");
            } else {
                output("impossible");
            }

            T--;
        }
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private boolean isPossible() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (bfs(i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        colors[num] = 1;
        visited[num] = true;
        q.add(num);

        while (!q.isEmpty()) {
            Integer presentNum = q.poll();

            for (int n : map.get(presentNum)) {
                if (colors[n] == 0) {
                    if (colors[presentNum] == 1) {
                        colors[n] = 2;
                        q.add(n);
                        visited[n] = true;
                    } else {
                        colors[n] = 1;
                        q.add(n);
                        visited[n] = true;
                    }
                } else {
                    if (colors[presentNum] == colors[n]) {
                        return false;
                    }else continue;
                }
            }
        }

        return true;
    }

    private void inputT() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        colors = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] line2 = br.readLine().split(" ");

            int a = Integer.parseInt(line2[0]);
            int b = Integer.parseInt(line2[1]);

            map.get(a).add(b);
            map.get(b).add(a);
        }
    }
}