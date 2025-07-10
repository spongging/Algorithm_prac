import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int n;
    private ArrayList<Integer> arr;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (true) {
            if (!input()) {
                break;
            }

            if (isPossible()) {
                output("POSSIBLE");
            } else {
                output("IMPOSSIBLE");
            }
        }
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private boolean isPossible() {
        int curDist = 0;

        for (int d : arr) {
            if (d - curDist <= 200) {
                curDist = d;
                continue;
            } else {
                return false;
            }
        }

        return (1422 - curDist) * 2 <= 200;
    }

    private boolean input() throws IOException {
        arr = new ArrayList<>();

        n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        return true;
    }
}