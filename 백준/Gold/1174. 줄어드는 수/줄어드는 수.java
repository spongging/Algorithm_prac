import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution{
    private int N;
    private ArrayList<Long> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();

        for (int i = 0; i <= 9; i++) {
            backTracking(i, Long.toString(i));
        }

        arr.sort((a, b) -> Long.compare(a, b));

        output();
    }

    private void output() {
        if (arr.size() < N) {
            System.out.println(-1);
        } else {
            System.out.println(arr.get(N - 1));
        }
    }

    private void backTracking(int idx, String num) {
        arr.add(Long.parseLong(num));
        for (int i = idx - 1; i >= 0; i--) {
            backTracking(i, num + (char) (i + '0'));
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}