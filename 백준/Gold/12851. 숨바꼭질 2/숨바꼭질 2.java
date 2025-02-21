import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int K;
    private int minTime = Integer.MAX_VALUE;
    private int answer = 0;
    private int[] dist = new int[100001];
    private int[] ways = new int[100001];

    public void solution() throws IOException {
        input();
        init();
        bfs();
        output();
    }

    private void output() {
        System.out.println(minTime);
        System.out.println(answer);
    }

    private void init() {
        for (int i = 0; i <= 100000; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }

        dist[N] = 0;
        ways[N] = 1;
    }

    private void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(N, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int curX = p.getX();
            int curTime = p.getTime();


            if (check(curX + 1, curTime+1, curX)) {
                q.add(new Pair(curX + 1, curTime + 1));
            }

            if (check(curX - 1, curTime+1,curX)) {
                q.add(new Pair(curX - 1, curTime + 1));
            }

            if (check(2 * curX, curTime+1, curX)) {
                q.add(new Pair(2 * curX, curTime + 1));
            }
        }

        minTime = dist[K];
        answer = ways[K];
    }

    private boolean check(int x, int curTime, int curX) {
        if (x >= 0 && x <= 100000) {
            if (dist[x] > curTime) {
                ways[x] = ways[curX];
                dist[x] = curTime;
                return true;
            } else if (dist[x] == curTime) {
                ways[x] += ways[curX];
            }

        } else {
            return false;
        }

        return false;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}

class Pair {
    private int x;
    private int time;

    public Pair(int x, int time) {
        this.x = x;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getTime() {
        return time;
    }
}
