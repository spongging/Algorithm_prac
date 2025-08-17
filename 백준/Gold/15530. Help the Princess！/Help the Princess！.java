import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] map;
    static int[][] soldierDist, princessDist;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) continue;
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            soldierDist = new int[H][W];
            princessDist = new int[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    soldierDist[i][j] = Integer.MAX_VALUE;
                    princessDist[i][j] = Integer.MAX_VALUE;
                }
            }

            boolean canEscape = solve();
            sb.append(canEscape ? "Yes\n" : "No\n");
        }
        System.out.print(sb.toString());
    }

    static boolean solve() {
        Queue<int[]> q = new LinkedList<>();
        int startR = -1, startC = -1;
        int exitR = -1, exitC = -1;

        // 병사 위치 큐에 넣기, 공주/출구 위치 찾기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '$') {
                    q.add(new int[]{i, j});
                    soldierDist[i][j] = 0;
                } else if (map[i][j] == '@') {
                    startR = i; startC = j;
                } else if (map[i][j] == '%') {
                    exitR = i; exitC = j;
                }
            }
        }

        // 1) 병사 BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!inRange(nr, nc)) continue;
                if (map[nr][nc] == '#') continue;
                if (soldierDist[nr][nc] > soldierDist[r][c] + 1) {
                    soldierDist[nr][nc] = soldierDist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // 2) 공주 BFS
        Queue<int[]> pq = new LinkedList<>();
        princessDist[startR][startC] = 0;
        pq.add(new int[]{startR, startC});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            int t = princessDist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (!inRange(nr, nc)) continue;
                if (map[nr][nc] == '#') continue;
                if (princessDist[nr][nc] <= t + 1) continue;

                // 병사보다 먼저 도착해야 함
                if (t + 1 < soldierDist[nr][nc]) {
                    princessDist[nr][nc] = t + 1;
                    if (map[nr][nc] == '%') return true; // 탈출 성공
                    pq.add(new int[]{nr, nc});
                }
            }
        }

        return false;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }
}
