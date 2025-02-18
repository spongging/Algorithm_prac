import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[][] arr;
    private int targetA;
    private int targetB;
    private static int answer = 0;
    private int[] da = {0, 1, 1};
    private int[] db = {1, 0, 1};

    public void solution() throws IOException {
        input();
        dfs(0, 0, 0, 1);
        output();
    }

    private void dfs(int firstA, int firstB, int secondA, int secondB) {

        if (secondA == targetA && secondB == targetB) {
            answer++;
            return;
        }

        int dir = checkDir(firstA, firstB, secondA, secondB);

        if (dir == 1) {
            if (secondB + 1 < N && arr[secondA][secondB + 1] == 0) {
                dfs(secondA, secondB, secondA, secondB + 1);
            }

            if (secondA + 1 < N && secondB + 1 < N && arr[secondA + 1][secondB + 1] == 0 && arr[secondA][secondB + 1] == 0 && arr[secondA + 1][secondB] == 0) {
                dfs(secondA, secondB, secondA + 1, secondB + 1);
            }

        } else if (dir == 2) {
            if (secondA + 1 < N && arr[secondA + 1][secondB] == 0) {
                dfs(secondA, secondB, secondA + 1, secondB);
            }

            if (secondA + 1 < N && secondB + 1 < N && arr[secondA + 1][secondB + 1] == 0 && arr[secondA][secondB + 1] == 0 && arr[secondA + 1][secondB] == 0) {
                dfs(secondA, secondB, secondA + 1, secondB + 1);
            }

        } else {

            if (secondB + 1 < N && arr[secondA][secondB + 1] == 0 ) {
                dfs(secondA, secondB, secondA, secondB + 1);
            }

            if (secondA + 1 < N && arr[secondA + 1][secondB] == 0) {
                dfs(secondA, secondB, secondA + 1, secondB);
            }

            if (secondA + 1 < N && secondB + 1 < N && arr[secondA + 1][secondB + 1] == 0 && arr[secondA][secondB + 1] == 0 && arr[secondA + 1][secondB] == 0) {
                dfs(secondA, secondB, secondA + 1, secondB + 1);
            }
        }
    }

    private int checkDir(int firstA, int firstB, int secondA, int secondB) {
        if (firstA == secondA) {
            if (firstB != secondB) {
                return 1;
            }
        } else {
            if (firstB != secondB) {
                return 3;
            } else {
                return 2;
            }
        }

        return 0;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        targetA = N - 1;
        targetB = N - 1;
    }

    private void output() {
        System.out.println(answer);
    }
}

