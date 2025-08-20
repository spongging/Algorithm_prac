import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, K;

    private final ArrayList<Integer> answerArr = new ArrayList<>();
    private final int[] dx = {-1, 1, 2};
    private final int[] arr = new int[200001];

    public void solution() throws IOException {
        input();
        bfs();
    }

    private void getPath() {
        int tmp = K;
        answerArr.add(tmp);

        if (N==K) return;

        while (true) {
            int parent = arr[tmp];
            answerArr.add(parent);
            tmp=parent;

            if (tmp == N) {
                break;
            }
        }
    }

    private void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[200001];

        q.add(new Pair(N, 0));
        visited[N] = true;
        arr[N] = N;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.getDis();
            int time = p.getTime();

            if (x == K) {
                getPath();
                output(time);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) {
                    nx = x * dx[i];

                } else {
                    nx = x + dx[i];
                }

                if (checkRange(nx) && !visited[nx]) {
                    arr[nx] = x;
                    visited[nx] = true;
                    q.add(new Pair(nx, time + 1));
                }
            }
        }
    }

    private void output(int time) {
        System.out.println(time);

        for (int i = answerArr.size() - 1; i >= 0; i--) {
            System.out.print(answerArr.get(i) + " ");
        }
    }

    private boolean checkRange(int nx) {
        return nx >= 0 && nx <= 200000;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
    }
}

class Pair {
    private final int dis;
    private final int time;

    public Pair(int dis, int time) {
        this.dis = dis;
        this.time = time;
    }

    public int getDis() {
        return dis;
    }

    public int getTime() {
        return time;
    }

}