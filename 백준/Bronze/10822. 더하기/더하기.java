import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private String[] line;

    public void solution() throws IOException {
        input();
        output(getAnswer());
    }

    private long getAnswer() {
        long sum = 0;
        for (int i = 0; i < line.length; i++) {
            sum += Long.parseLong(line[i]);
        }

        return sum;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(",");
    }
}