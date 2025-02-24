import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int K;
    private int P;
    private int X;
    private int[] xDigit;
    private int[] targetDigit;
    private int answer = 0;

    private boolean[][] ledStates = {
            {true, true, true, false, true, true, true},
            {false, false, true, false, false, false, true},
            {false, true, true, true, true, true, false},
            {false, true, true, true, false, true, true},
            {true, false, true, true, false, false, true},
            {true, true, false, true, false, true, true},
            {true, true, false, true, true, true, true},
            {false, true, true, false, false, false, true},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true},
    };


    public void solution() throws IOException {
        input();
        xDigit = dividingDigit(X);
        countReversePossible();
        output();
    }

    private void countReversePossible() {
        targetDigit = new int[K];

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            targetDigit = dividingDigit(i);
            if (isReversePossible()) {
                answer++;
            }
        }
    }

    private boolean isReversePossible() {
        int count = 0;

        for (int i = 0; i < K; i++) { //자릿수
            for (int j = 0; j < 7; j++) {
                if (ledStates[xDigit[i]][j] != ledStates[targetDigit[i]][j]) {
                    count++;

                    if (count > P) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int[] dividingDigit(int x) {
        int[] tmp = new int[K];

        for (int i = K - 1; i >= 0; i--) {
            int num = x % 10;
            x /= 10;
            tmp[i] = num;
        }

        return tmp;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

    }

    private void output() {
        System.out.println(answer);
    }
}
