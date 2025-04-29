import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int M, N;
    private int[][] arr;
    private ArrayList<Pair> airconIdx = new ArrayList<>();
    private boolean[][] visited;
    private boolean[][][] visited2;


    public void solution() throws IOException {
        input();
        searching();
        output(countingPath());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int countingPath() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void searching() {
        int[] da = {-1, 0, 1, 0};
        int[] db = {0, 1, 0, -1};

        for (Pair p : airconIdx) {
            int aa = p.getA();
            int bb = p.getB();

            visited[aa][bb] = true;

            for (int i = 1; i <= 4; i++) {
                int na = aa + da[i - 1];
                int nb = bb + db[i - 1];

                if (na >= 0 && na < N && nb >= 0 && nb < M) {
                    if (visited2[na][nb][i]) continue;
                    findingWindPath(na, nb, i);
                }
            }
        }
    }

    private void findingWindPath(int x, int y, int dir) {
        while (true) {
            if (x < 0 || x >= N || y < 0 || y >= M) {
                break;
            }

            if (visited2[x][y][dir]) break;

            visited[x][y] = true;
            visited2[x][y][dir] = true;

            if (arr[x][y] != 0) { // 방향 전환
                if (arr[x][y] == 1) {
                    if (dir == 2 || dir == 4) {
                        break;
                    }
                } else if (arr[x][y] == 2) {
                    if (dir == 1 || dir == 3) {
                        break;
                    }
                } else if (arr[x][y] == 3) {
                    if (dir == 1) {
                        dir = 2;
                    } else if (dir == 2) {
                        dir = 1;
                    } else if (dir == 3) {
                        dir = 4;
                    } else {
                        dir = 3;
                    }
                } else if (arr[x][y] == 4) {
                    if (dir == 1) {
                        dir = 4;
                    } else if (dir == 2) {
                        dir = 3;
                    } else if (dir == 3) {
                        dir = 2;
                    } else {
                        dir = 1;
                    }
                }
            }

            if (dir == 1) { // 전진
                x = x - 1;
            } else if (dir == 2) {
                y = y + 1;
            } else if (dir == 3) {
                x = x + 1;
            } else {
                y = y - 1;
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M][5];

        for (int i = 0; i < N; i++) {
            String[] line1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(line1[j]);
                arr[i][j] = num;

                if (num == 9) {
                    airconIdx.add(new Pair(i, j));
                }
            }
        }
    }
}

class Pair {
    private int a;
    private int b;

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