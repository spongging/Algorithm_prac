import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private final Set<Integer> arr = new HashSet<>();
    private final ArrayList<Integer> nums = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();
        output(getAnswer());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getAnswer() {
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                int ij = nums.get(i) * nums.get(j);

                for (int k = j; k < nums.size(); k++) {
                    int prod = ij * nums.get(k);

                    if (prod == N) {
                        return 0;
                    } else if (prod < N && Math.abs(N - prod) < best) {
                        best = N - prod;
                    } else if (prod > N && Math.abs(N - prod) < best) {
                        best = Math.abs(N - prod);
                        break;
                    }
                }
            }
        }

        return best;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line2 = br.readLine().split(" ");
        N = Integer.parseInt(line2[0]);
        M = Integer.parseInt(line2[1]);

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        for (int i = 1; i <= 1001; i++) {
            if (!arr.contains(i)) {
                nums.add(i);
            }
        }
    }
}