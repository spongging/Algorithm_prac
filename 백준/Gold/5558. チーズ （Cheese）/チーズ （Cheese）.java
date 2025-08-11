import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution{
    private int H, W, N;
    private int startX, startY, maxHp = 0;

    private char[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        inputAndInit();
        output(bfs());
    }

    private int bfs(){
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][maxHp + 2];

        q.add(new Pair(startY, startX, 0, 1));
        visited[startY][startX][1] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int cnt = p.getCnt();
            int hp = p.getHp();

            if (hp == maxHp + 1) return cnt;

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < H && nb < W && !visited[na][nb][hp]) {
                    if (map[na][nb]=='X') continue;

                    if (map[na][nb] == '.') {
                        visited[na][nb][hp] = true;
                        q.add(new Pair(na, nb, cnt + 1, hp));

                    } else {
                        int tmpHp = map[na][nb] - '0';

                        if (tmpHp == hp) {
                            visited[na][nb][hp + 1] = true;
                            q.add(new Pair(na, nb, cnt + 1, tmpHp + 1));
                        } else {
                            visited[na][nb][hp] = true;
                            q.add(new Pair(na, nb, cnt + 1, hp));
                        }
                    }
                }
            }
        }

        return -1;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        H = Integer.parseInt(line[0]);
        W = Integer.parseInt(line[1]);
        N = Integer.parseInt(line[2]);

        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine().trim();

            for (int j = 0; j < W; j++) {
                if (s.charAt(j) == 'S') {
                    startY = i;
                    startX = j;
                }

                if (s.charAt(j) >= '1' && s.charAt(j) <= '9') {
                    maxHp = Math.max(maxHp, s.charAt(j) - '0');
                }

                map[i][j] = s.charAt(j);
            }
        }
    }
}

class Pair {
    private final int a;
    private final int b;
    private final int cnt;
    private final int hp;

    public Pair(int a, int b, int cnt, int hp) {
        this.a = a;
        this.b = b;
        this.cnt = cnt;
        this.hp = hp;
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

    public int getHp() {
        return hp;
    }
}