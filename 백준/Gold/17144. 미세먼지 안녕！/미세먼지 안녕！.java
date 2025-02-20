import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();;
    }
}

class Solution {
    private int R;
    private int C;
    private int T;
    private int[][] arr;
    private int[][] copyArr;
    private int[] da = {0, 0, 1, -1};
    private int[] db = {1, -1, 0, 0};
    private int topA;
    private int topB;
    private int bottomA;
    private int bottomB;
    private ArrayList<Pair> list = new ArrayList<>();
    private int answer;

    public void solution() throws IOException {
        input();

        while (T > 0) {
            diffusion();
            operation();
            T--;
        }
        totalDust();
        output();
    }

    private void diffusion() {
        findDustAndCal();
    }

    private void findDustAndCal() {
        copyArr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == -1){
                    copyArr[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    cal(i ,j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.arraycopy(copyArr[i], 0, arr[i], 0, C);
        }
    }

    private void cal(int a, int b) {
        int count = 0;
        int div = arr[a][b] / 5;

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && na < R && nb >= 0 && nb < C && arr[na][nb] != -1) {
                copyArr[na][nb] += div;
                count++;
            }
        }

        copyArr[a][b] += arr[a][b] - (div * count);
    }

    private void operation() {
        findIdxOfMachine();
        topOperation();
        bottomOperation();
    }

    private void topOperation() {
        for (int i = topA - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }

        for (int i = 0; i < topA; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            arr[topA][i] = arr[topA][i - 1];
        }

        arr[topA][1] = 0;
    }

    private void bottomOperation() {
        for (int i = bottomA + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }

        for (int j = 0; j < C - 1; j++) {
            arr[R - 1][j] = arr[R - 1][j + 1];
        }

        for (int i = R - 1; i > bottomA; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }

        for (int j = C - 1; j > 1; j--) {
            arr[bottomA][j] = arr[bottomA][j - 1];
        }

        arr[bottomA][1] = 0;
    }

    private void findIdxOfMachine() {
        Pair p1 = list.get(0);
        Pair p2 = list.get(1);

        topA = p1.getA();
        topB = p1.getB();

        bottomA = p2.getA();
        bottomB = p2.getB();
    }

    private void totalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += arr[i][j];
            }
        }

        answer = sum + 2;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(line[j]);

                if (Integer.parseInt(line[j]) == -1) {
                    list.add(new Pair(i, j));
                }
            }
        }
    }

    private void output() {
        System.out.println(answer);
    }
}

class Pair {
    int a;
    int b;

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
