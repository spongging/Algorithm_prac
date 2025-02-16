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

class Solution {
    private int N;
    private int[] arr;
    private int[] cntToRight;
    private int[] cntToLeft;

    public void solution() throws IOException {
        input();
        countToRight();
        countToLeft();
        findLongLength();
    }

    private void countToRight() {
        for (int i = 0; i < N; i++) {
            cntToRight[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    cntToRight[i] = Math.max(cntToRight[i], cntToRight[j] + 1);
                }
            }
        }
    }

    private void countToLeft() {
        for (int i = N - 1; i >= 0; i--) {
            cntToLeft[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    cntToLeft[i] = Math.max(cntToLeft[i], cntToLeft[j] + 1);
                }
            }
        }
    }

    private void findLongLength() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, cntToRight[i] + cntToLeft[i] - 1);
        }
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cntToRight = new int[N];
        cntToLeft = new int[N];
    }
}
