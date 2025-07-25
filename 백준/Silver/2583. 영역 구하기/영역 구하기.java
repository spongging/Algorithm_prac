import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N,M, K;
    private int blankCnt = 0;

    private final ArrayList<Square> squares = new ArrayList<>();
    private final int[] da = {1, -1, 0, 0};
    private final int[] db = {0, 0, 1, -1};

    boolean[][] visited;
    private final ArrayList<Integer> blankAreas = new ArrayList<>();

    public void solution() throws IOException {
        input();

        for (Square square : squares) {
            fillArea(square.getA1(), square.getB1(), square.getA2(), square.getB2());
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    blankCnt++;
                    blankAreas.add(getBlankArea(i, j));
                }
            }
        }

        Collections.sort(blankAreas);
        output();
    }

    private void output() {
        System.out.println(blankCnt);

        for (int i = 0; i < blankAreas.size(); i++) {
            System.out.print(blankAreas.get(i));
            if (i == blankAreas.size() - 1) {
                break;
            }
            System.out.print(" ");
        }
    }

    private int getBlankArea(int a, int b) {
        int area = 1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(a, b));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            for (int i = 0; i < 4; i++) {
                int na = aa + da[i];
                int nb = bb + db[i];

                if (na >= 0 && nb >= 0 && na < M && nb < N && !visited[na][nb]) {
                    area++;
                    visited[na][nb] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }

        return area;
    }

    private void fillArea(int a1, int b1, int a2, int b2) {
        for (int i = a1; i < a2; i++) {
            for (int j = b1; j < b2; j++) {
                visited[i][j] = true;
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");

            int b1 = Integer.parseInt(line[0]);
            int a1 = Integer.parseInt(line[1]);
            int b2 = Integer.parseInt(line[2]);
            int a2 = Integer.parseInt(line[3]);

            squares.add(new Square(b1, b2, a1, a2));
        }

        visited = new boolean[M][N];
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

class Square {
    private int b1;
    private int b2;
    private int a1;
    private int a2;

    public Square(int b1, int b2, int a1, int a2) {
        this.b1 = b1;
        this.b2 = b2;
        this.a1 = a1;
        this.a2 = a2;
    }

    public int getB1() {
        return b1;
    }

    public int getB2() {
        return b2;
    }

    public int getA1() {
        return a1;
    }

    public int getA2() {
        return a2;
    }
}