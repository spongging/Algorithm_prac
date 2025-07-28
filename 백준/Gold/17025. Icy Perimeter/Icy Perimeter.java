import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int answerArea = 0;
    private int answerPerimeter = Integer.MAX_VALUE;
    private int tmpArea;
    private int tmpPerimeter;

    private char[][] map;
    private boolean[][] visited;
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    getAreaAndPerimeter(i, j);

                    if (answerArea == tmpArea) {
                        if (answerPerimeter > tmpPerimeter) {
                            answerPerimeter = tmpPerimeter;
                        }
                    } else if (answerArea < tmpArea) {
                        answerArea = tmpArea;
                        answerPerimeter = tmpPerimeter;
                    }
                }
            }
        }

        output();
    }

    private void output() {
        System.out.println(answerArea + " " + answerPerimeter);
    }

    private void getAreaAndPerimeter(int a, int b) {
        int tmpA = 1;
        int tmpP = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        visited[a][b] = true;

        tmpP += getTmpPerimeter(a, b);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < N && nb < N && !visited[na][nb] && map[na][nb] == '#') {
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));

                    tmpA++;
                    tmpP += getTmpPerimeter(na, nb);
                }
            }
        }

        tmpArea = tmpA;
        tmpPerimeter = tmpP;
    }

    private int getTmpPerimeter(int a, int b) {
        int tmp = 0;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && nb >= 0 && na < N && nb < N && map[na][nb] == '#') {
                continue;
            } else {
                tmp++;
            }
        }

        return tmp;
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
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
