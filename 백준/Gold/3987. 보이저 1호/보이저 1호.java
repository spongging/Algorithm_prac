import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution{
    private int N;
    private int M;
    private char[][] arr;
    private int PR;
    private int PC;
    private boolean[][][] visited;
    private int startDir;
    private int resultDir;
    private int resultCnt = 0;

    public void solution() throws IOException {
        input();

        for (int i = 1; i <= 4; i++) {
            visited = new boolean[N][M][5];

            startDir = i;

            int cnt = goStraight();

            if (cnt == -1) {
                printResult(startDir, cnt);
                return;
            }

            if (resultCnt < cnt) {
                resultCnt = cnt;
                resultDir = startDir;
            }
        }

        printResult(resultDir, resultCnt);

    }

    private int goStraight() {
        int presentDir = startDir;
        int cnt = 0;
        int tmpA = PR;
        int tmpB = PC;

        while (true) {
            if (tmpA < 0 || tmpB < 0 || tmpA >= N || tmpB >= M) {
                break;
            }

            if (arr[tmpA][tmpB] == 'C') {
                break;
            }

            if (visited[tmpA][tmpB][presentDir] == true) {
                cnt = -1;
                break;
            }

            visited[tmpA][tmpB][presentDir] = true;

            if (arr[tmpA][tmpB] == '/') {
                if (presentDir == 1) {
                    presentDir = 2;
                } else if (presentDir == 2) {
                    presentDir = 1;
                } else if (presentDir == 3) {
                    presentDir = 4;
                } else {
                    presentDir = 3;
                }
            } else if (arr[tmpA][tmpB] == '\\') {
                if (presentDir == 1) {
                    presentDir = 4;
                } else if (presentDir == 2) {
                    presentDir = 3;
                } else if (presentDir == 3) {
                    presentDir = 2;
                } else {
                    presentDir = 1;
                }
            }

            if (presentDir == 1) {
                tmpA--;

            } else if (presentDir == 2) {
                tmpB++;

            } else if (presentDir == 3) {
                tmpA++;

            } else {
                tmpB--;

            }

            cnt++;
        }

        return cnt;
    }

    private void printResult(int resultDir, int cnt) {
        if (resultDir == 1) {
            System.out.println('U');
        } else if (resultDir == 2) {
            System.out.println('R');
        } else if (resultDir == 3) {
            System.out.println('D');
        } else {
            System.out.println('L');
        }

        if (cnt == -1) {
            System.out.println("Voyager");
        } else {
            System.out.println(cnt);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0 ; i < N ; i++){
            String line = br.readLine();
            arr[i] = line.toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        PR = Integer.parseInt(st.nextToken());
        PC = Integer.parseInt(st.nextToken());

        PR--;
        PC--;
    }
}
