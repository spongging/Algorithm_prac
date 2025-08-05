import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private boolean flag = false;

    private final ArrayList<Integer> nums = new ArrayList<>();

    public void solution() throws IOException {
        input();
        backTracking(0);
    }

    private void output() {
        for (int n : nums) {
            System.out.print(n);
        }
    }

    private void backTracking(int level) {
        if (level == N) {
            output();
            System.exit(0);
        }

        if (flag) return;

        for (int i = 1; i <= 3; i++) {
            nums.add(i);

            if (isGood(level + 1)) {
                backTracking(level + 1);
            }
            
            nums.remove(nums.size() - 1);
        }
    }

    private boolean isGood(int len) {

        for (int L = 1; L <= len / 2; L++) {
            for (int i = 0; i + 2 * L <= len; i++) {
                for (int k = 0; k < L; k++) {
                    if (!Objects.equals(nums.get(i + k), nums.get(i + k + L))) {
                        break;
                    }

                    if (k == L - 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
    }
}