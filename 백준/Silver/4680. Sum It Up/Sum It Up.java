import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, N;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Integer> arr;
    private boolean flag;
    private Set<String> set = new HashSet<>();

    public void solution() throws IOException {
        while (true) {
            input();

            if (N == 0) {
                break;
            }

            System.out.println("Sums of " + T + ":");

            flag = false;
            dfs(0, 0, 0, "");

            if (!flag) {
                System.out.println("NONE");
            }
        }
    }

    private void dfs(int level,int idx, int sum, String s) {
        if (sum == T) {
            if (isDuplicate(s)) {
                return;
            }

            set.add(s);
            flag = true;

            output(s);
            return;
        }
        
        if (idx == N) {
            return;
        }
        
        if (sum > T) {
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(level + 1, i + 1, sum + arr.get(i), s + arr.get(i).toString() + " ");
        }
    }

    private boolean isDuplicate(String s) {
        return set.contains(s);
    }

    private void output(String s) {
        String[] numArr = s.split(" ");

        for (int i = 0; i < numArr.length; i++) {
            if (Objects.equals(numArr[i], " ")) {
                continue;
            }

            int num = Integer.parseInt(String.valueOf(numArr[i]));

            if (i == numArr.length - 1) {
                System.out.println(num);

            } else {
                System.out.print(num + "+");
            }
        }
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        T = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);

        arr = new ArrayList<>();
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i + 2]));
        }

        arr.sort(Collections.reverseOrder());
    }
}