import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private boolean flag = false;

    private final char[][] map = new char[10][10];
    private final ArrayList<State> states = new ArrayList<>();
    private final int[] ships = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    private final int[] da = {-1, -1, 0, 1, 1, 1, 0, -1};
    private final int[] db = {0, 1, 1, 1, 0, -1, -1, -1};

    public void solution() throws IOException {
        inputAndInit();
        backtracking(0);
        output();
    }

    private void output() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void backtracking(int idx) {
        if (idx == ships.length) {
            flag = true;
            return;
        }
        if (flag) return;

        int len = ships[idx];
        for (State state : states) {
            int ca = state.getA();
            int cb = state.getB();

            for (int dir = 0; dir <= 1; dir++) {
                // try all offsets so that (ca,cb) can be any part of the ship
                for (int offset = 0; offset < len; offset++) {
                    int sa = dir == 0 ? ca : ca - offset;
                    int sb = dir == 0 ? cb - offset : cb;

                    if (isPossible(sa, sb, len, dir)) {
                        putShip(sa, sb, len, dir, '#');
                        backtracking(idx + 1);
                        if (flag) return;
                        putShip(sa, sb, len, dir, '.');
                    }
                }
            }
        }
    }

    private void putShip(int ca, int cb, int len, int dir, char c) {
        if (dir == 0) {
            for (int i = 0; i < len; i++) {
                map[ca][cb + i] = c;
            }
        } else {
            for (int i = 0; i < len; i++) {
                map[ca + i][cb] = c;
            }
        }
    }

    private boolean isPossible(int ca, int cb, int len, int dir) {
        if (dir == 0) {
            // horizontal
            for (int i = 0; i < len; i++) {
                int nb = cb + i;
                if (ca < 0 || ca >= 10 || nb < 0 || nb >= 10 || map[ca][nb] != '.') return false;
                // check adjacency
                for (int j = 0; j < 8; j++) {
                    int ra = ca + da[j];
                    int rb = nb + db[j];
                    if (ra >= 0 && ra < 10 && rb >= 0 && rb < 10 && map[ra][rb] == '#') return false;
                }
            }
        } else {
            // vertical
            for (int i = 0; i < len; i++) {
                int na = ca + i;
                if (na < 0 || na >= 10 || cb < 0 || cb >= 10 || map[na][cb] != '.') return false;
                // check adjacency
                for (int j = 0; j < 8; j++) {
                    int ra = na + da[j];
                    int rb = cb + db[j];
                    if (ra >= 0 && ra < 10 && rb >= 0 && rb < 10 && map[ra][rb] == '#') return false;
                }
            }
        }
        return true;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = '.';
                states.add(new State(i, j, Integer.parseInt(line[j])));
            }
        }
        Collections.sort(states);
    }
}

class State implements Comparable<State> {
    private final int a, b, time;

    public State(int a, int b, int time) {
        this.a = a;
        this.b = b;
        this.time = time;
    }
    public int getA() { return a; }
    public int getB() { return b; }
    public int getTime() { return time; }

    @Override
    public int compareTo(State o) {
        return o.time - this.time;
    }
}
