import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int K;
    private int N;
    private char[][] map;
    private int[] init;
    private int[] target;
    private int blankLine;
    private char[] resultArr;

    public void solution() throws IOException {
        input();
        upToDown();
        downToUp();
        comparing();

        if (isPossible()) {
            outputOfTrue();
        } else {
            outputOfFalse();
        }
    }

    private boolean isPossible() {
        for (int i = 0; i < K; i++) {
            if (init[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    private void outputOfFalse() {
        for (int i = 0; i < K - 1; i++) {
            System.out.print('x');
        }
    }

    private void outputOfTrue() {
        for (int i = 0; i < K - 1; i++) {
            System.out.print(resultArr[i]);
        }
    }

    private void comparing() {
        for (int i = 0; i < K - 1; i++) {
            if (init[i] == target[i]) {
                resultArr[i] = '*';
            } else {
                resultArr[i] = '-';
                swap(target, i);
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j+1] = tmp;
    }

    private void upToDown() {
        for (int i = 0; i < blankLine; i++) {
            for (int j = 0; j < K; j++) {
                if (map[i][j] == '-') {
                    swap(init, j);
                }
            }
        }
    }

    private void downToUp() {
        for (int i = N - 1; i > blankLine; i--) {
            for (int j = 0; j < K; j++) {
                if (map[i][j] == '-') {
                    swap(target, j);
                }
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        map = new char[N][K];
        init = new int[K];
        target = new int[K];
        resultArr = new char[K];

        String line1 = br.readLine();

        for (int i = 0; i < K; i++) {
            target[i] = line1.charAt(i) - 'A';
        }

        for (int i = 0; i < K; i++) {
            init[i] = i;
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < K - 1; j++) {
                if (line.charAt(j) == '?') {
                    blankLine = i;
                }
                map[i][j] = line.charAt(j);
            }
        }
    }

}