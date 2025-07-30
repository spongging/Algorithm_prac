import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T,N, M;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        while (T > 0) {
            input();
            output(getAnswer());
            T--;
        }
    }

    private int getAnswer() {
        if (N == 1) return 0;
        if (N == 2) return M;
        return (N - 1) + (M - 1) * 2;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
    }
}