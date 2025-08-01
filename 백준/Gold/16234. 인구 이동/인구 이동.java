import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, L, R;
    private boolean isPossible;
    private int answer = 0;

    private int[][] map;
    private boolean[][] visited;  // 연합 탐색용 (한 턴에서 이미 연합에 포함된 칸)
    private final int[] da = {0, 0, 1, -1};
    private final int[] db = {1, -1, 0, 0};

    public void solution() throws IOException {
        inputAndInit();

        while (true) {
            isPossible = false;
            visited = new boolean[N][N]; // 이 턴에서 처리한 연합 포함 여부

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        processUnion(i, j);
                    }
                }
            }

            if (!isPossible) break;
            answer++;
        }

        output();
    }

    private void processUnion(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        List<Pair> union = new ArrayList<>();
        q.add(new Pair(a, b));
        visited[a][b] = true;
        int sum = 0;
        int count = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            union.add(p);
            sum += map[aa][bb];
            count++;

            for (int d = 0; d < 4; d++) {
                int na = aa + da[d];
                int nb = bb + db[d];
                if (na >= 0 && nb >= 0 && na < N && nb < N && !visited[na][nb]) {
                    if (check(map[aa][bb], map[na][nb])) {
                        visited[na][nb] = true;
                        q.add(new Pair(na, nb));
                    }
                }
            }
        }

        if (count > 1) {
            isPossible = true;
            int avg = sum / count;
            for (Pair cell : union) {
                map[cell.getA()][cell.getB()] = avg;
            }
        }
        // 연합 크기 1이면 변화 없고 isPossible 영향 없음
    }

    private void output() {
        System.out.println(answer);
    }

    private boolean check(int n1, int n2) {
        int dist = Math.abs(n1 - n2);
        return dist >= L && dist <= R;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
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
