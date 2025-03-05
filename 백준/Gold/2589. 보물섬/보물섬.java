import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int M;
    private char[][] arr;
    private int[] da = {0, 0, -1, 1};
    private int[] db = {1, -1, 0, 0};
    private ArrayList<LandCoord> landCoords = new ArrayList<>();
    private int answer = 0;

    public void solution() throws IOException {
        input();
        findCoordOfTreasure();
        output();
    }

    private void findCoordOfTreasure() {
        for (LandCoord landCoord : landCoords) {
            int AofLandCoord = landCoord.getA();
            int BofLandCoord = landCoord.getB();

            answer = Math.max(answer, bfs(AofLandCoord, BofLandCoord));
        }
    }

    private int bfs(int firstA, int firstB) {
        int maxCnt = -1;
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(firstA, firstB, 0));
        visited[firstA][firstB] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int aa = p.getA();
            int bb = p.getB();
            int cnt = p.getCnt();

            maxCnt = Math.max(maxCnt, cnt);

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && na < N && nb >= 0 && nb < M && !visited[na][nb] && arr[na][nb] == 'L') {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb, cnt + 1));
                }
            }
        }

        return maxCnt;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                arr[i][j] = c;

                if (c == 'L') {
                    landCoords.add(new LandCoord(i, j));
                }
            }
        }
    }

    private void output() {
        System.out.println(answer);
    }
}

class LandCoord {
    private int a;
    private int b;

    public LandCoord(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

class Pair {
    private int a;
    private int b;
    private int cnt;

    public Pair(int a, int b, int cnt) {
        this.a = a;
        this.b = b;
        this.cnt = cnt;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCnt() {
        return cnt;
    }
}