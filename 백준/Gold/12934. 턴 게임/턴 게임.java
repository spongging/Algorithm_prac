import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private long x, y;
    private int n;
    private ArrayList<Integer> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        if (isPossible()) {
            makeArr();
            output(getWinCount());
        } else {
            output(-1);
        }
    }

    private void makeArr() {
        arr.add(0);
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
    }

    private long getWinCount() {
        long cnt = 0;

        if (x == 0) {
            return 0;
        }

        for (int i = n; i >= 1; i--) {
            int tmp = arr.get(i);

            if (tmp < x) {
                x -= tmp;
                cnt++;
            } else {
                cnt++;
                break;
            }
        }

        return cnt;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private boolean isPossible() {
        long D = 1 + 8 * (x + y);
        long t = (long) Math.sqrt(D);

        if (t * t != D) {
            return false;
        }

        n = (int) (t - 1) / 2;

        return (t - 1) % 2 == 0;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        x = Long.parseLong(line[0]);
        y = Long.parseLong(line[1]);
    }
}