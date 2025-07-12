import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int n,a, b;
    private int[][] arr;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (true) {
            if (!input()) {
                break;
            }

            int countW = countWidth();
            int countL = countLength();

            if (countW == 0) {
                if (countL == 0) {
                    output("OK");
                } else {
                    output("Corrupt");
                }
            } else if (countW == 1) {
                if (countL == 1) {
                    output("Change bit (" + (a + 1) + "," + (b + 1) + ")");
                } else {
                    output("Corrupt");
                }
            } else {
                output("Corrupt");
            }
        }
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private int countWidth() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }

            if (cnt % 2 != 0) {
                if (count == 0) {
                    a = i;
                }
                count++;
            }
        }

        return count;
    }

    private int countLength() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 1) {
                    cnt++;
                }
            }

            if (cnt % 2 != 0) {
                if (count == 0) {
                    b = i;
                }
                count++;
            }
        }

        return count;
    }

    private boolean input() throws IOException {
        n = Integer.parseInt(br.readLine());

        if (n==0) return false;

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        return true;
    }
}