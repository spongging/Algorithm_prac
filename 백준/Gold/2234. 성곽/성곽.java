import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private int roomCnt = 0;
    private int maxRoomSize = -1;
    private int maxAroundRoomSize = -1;

    private int[][] map;
    private int[][] roomIdArr;
    private boolean[][] visited;
    private final int[] da = {0, -1, 0, 1};
    private final int[] db = {-1, 0, 1, 0};
    private final ArrayList<Integer> roomSizes = new ArrayList<>();

    public void solution() throws IOException {
        input();

        int roomId = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int tmpSize = getCountAndRoomId(i, j, ++roomId);
                    roomCnt++;
                    maxRoomSize = Math.max(maxRoomSize, tmpSize);
                    roomSizes.add(tmpSize);
                }
            }
        }

        bw.write(roomCnt + "\n");
        bw.write(maxRoomSize + "\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                getAroundRoomSize(i, j);
            }
        }

        bw.write(maxAroundRoomSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void getAroundRoomSize(int a, int b) {
        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (checkRange(na, nb) && roomIdArr[a][b] != roomIdArr[na][nb]) {
                maxAroundRoomSize = Math.max(maxAroundRoomSize, roomSizes.get(roomIdArr[na][nb] - 1) + roomSizes.get(roomIdArr[a][b] - 1));
            }
        }
    }

    private int getCountAndRoomId(int a, int b, int roomId) {
        int cnt = 1;
        Queue<Pair> q = new LinkedList<>();

        visited[a][b] = true;
        q.add(new Pair(a, b));
        roomIdArr[a][b] = roomId;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (checkRange(na, nb) && checkWall(aa, bb, i) && !visited[na][nb]) {
                    visited[na][nb] = true;
                    roomIdArr[na][nb] = roomId;
                    q.add(new Pair(na, nb));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean checkWall(int na, int nb, int dir) {
        return (map[na][nb] & (1 << dir)) == 0;
    }

    private boolean checkRange(int na, int nb) {
        return na >= 0 && nb >= 0 && na < N && nb < M;
    }

    private void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        roomIdArr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Pair {
    private final int a;
    private final int b;

    public Pair(int a, int b) {
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