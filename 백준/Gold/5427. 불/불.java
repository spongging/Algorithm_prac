import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int N, M, answer;
    private boolean flag;

    private char[][] map;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};
    private boolean[][] visited;
    private boolean[][] fireVisited;
    private final Queue<Pair> sangCoords = new LinkedList<>();
    private final Queue<FireState> fireCoords = new LinkedList<>();

    public void solution() throws IOException {
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            inputAndInit();

            while (true) {

                if (sangCoords.isEmpty()) {
                    output(-1);
                    break;
                }

                movingFire();
                movingSang();
                
                if (flag){
                    output(answer);
                    break;
                }

            }
        }
    }

    private void movingFire() {
        Queue<FireState> tmp = new LinkedList<>();

        while (!fireCoords.isEmpty()) {
            FireState p = fireCoords.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (isNotOut(na, nb) && map[na][nb] != '#' && !fireVisited[na][nb]) {
                    fireVisited[na][nb] = true;
                    map[na][nb] = '*';
                    tmp.add(new FireState(na, nb));
                }
            }
        }

        fireCoords.addAll(tmp);
    }

    private void output(int answer) {
        if (answer == -1) {
            System.out.println("IMPOSSIBLE");

        } else {
            System.out.println(answer);
        }
    }

    private void movingSang() {
        Queue<Pair> tmpQ = new LinkedList<>();

        while (!sangCoords.isEmpty()) {
            Pair p = sangCoords.poll();
            int aa = p.getA();
            int bb = p.getB();
            int time = p.getTime();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (!isNotOut(na, nb)) {
                    answer = time + 1;
                    flag = true;
                    return;
                }

                if (map[na][nb] == '.' && !visited[na][nb]) {
                    visited[na][nb] = true;
                    map[na][nb] = '@';
                    tmpQ.add(new Pair(na, nb, time + 1));
                }
            }
        }

        sangCoords.addAll(tmpQ);
    }

    private boolean isNotOut(int na, int nb) {
        return na >= 0 && nb >= 0 && na < N && nb < M;
    }

    private void inputAndInit() throws IOException {
        String[] line = br.readLine().split(" ");

        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);

        map = new char[N][M];
        visited = new boolean[N][M];
        fireVisited = new boolean[N][M];
        sangCoords.clear();
        fireCoords.clear();
        flag = false;

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (s.charAt(j) == '@') {
                    visited[i][j] = true;
                    sangCoords.add(new Pair(i, j, 0));

                } else if (s.charAt(j) == '*') {
                    fireCoords.add(new FireState(i, j));
                }
            }
        }
    }
}

class FireState {
    private final int a;
    private final int b;

    public FireState(int a, int b) {
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
    private final int a;
    private final int b;
    private final int time;

    public Pair(int a, int b, int time) {
        this.a = a;
        this.b = b;
        this.time = time;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getTime() {
        return time;
    }
}