import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int P;
    private int K, N;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        P = Integer.parseInt(br.readLine().trim());

        while (P > 0) {
            input();
            output(getS1(), getS2(), getS3());
            P--;
        }
    }

    private int getS1() {
        return N * (N + 1) / 2;
    }

    private int getS2() {
        return N * N;
    }

    private int getS3() {
        return N * (N + 1);
    }

    private void output(int s1, int s2, int s3) {
        System.out.println(K + " " + s1 + " " + s2 + " " + s3);
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        K = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
    }
}