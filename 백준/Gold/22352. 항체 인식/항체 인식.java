import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int M,N;
    private int[][] beforeArr;
    private int[][] afterArr;
    private boolean[][] visited;
    private boolean flag = false;

    public void solution() throws IOException {
        input();
        searching();
    }

    private void searching() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (beforeArr[i][j] != afterArr[i][j] && !visited[i][j]) {
                    if (bfs(beforeArr[i][j], afterArr[i][j], i, j)) {
                        continue;
                    } else {
                        output("NO");
                        return;
                    }
                }
            }
        }

        output("YES");
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private boolean bfs(int beforeNum, int afterNum, int initA, int initB) {
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(initA, initB));
        visited[initA][initB] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < N && nb < M && !visited[na][nb]) {
                    if (beforeArr[na][nb] == beforeNum) {
                        if (afterArr[na][nb] == afterNum) {
                            visited[na][nb] = true;
                            q.add(new Pair(na, nb));
                        } else {
                            return false;
                        } 
                    } else if (beforeArr[na][nb] != afterArr[na][nb]) {
                        return false;
                    }
                }
            }
        }

        if (flag) {
            return false;
        } else {
            flag = true;
            return true;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        beforeArr = new int[N][M];
        afterArr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                beforeArr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                afterArr[i][j] = Integer.parseInt(line[j]);
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