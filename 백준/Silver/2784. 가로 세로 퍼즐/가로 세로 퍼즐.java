import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final String[] arr = new String[6];
    private final boolean[] visited = new boolean[6];
    private final ArrayList<Integer> nums = new ArrayList<>();
    private char[][] puzzle;

    public void solution() throws IOException {
        input();

        for (int i = 0; i < 6; i++) {
            visited[i] = true;
            nums.add(i);
            dfs(1);
            visited[i] = false;
            nums.remove(nums.size() - 1);
        }

        output(0);
    }

    private void output(int flag) {
        if (flag == 1) {
            for (int i = 0; i < 3; i++) {
                String s = String.valueOf(puzzle[i]);
                System.out.println(s);
            }

        }else System.out.println(0);
    }

    private void makingPuzzle() {
        puzzle = new char[3][3];
        int rowIdx = 0;

        for (int num : nums) {
            String s = String.valueOf(arr[num]);

            for (int i = 0; i < s.length(); i++) {
                puzzle[rowIdx][i] = s.charAt(i);
            }

            rowIdx++;
        }

    }

    private boolean isPossible() {
        boolean[] visited2 = new boolean[6];

        System.arraycopy(visited, 0, visited2, 0, 6);

        for (int i = 0; i < 3; i++) {
            StringBuilder s = new StringBuilder();

            for (int j = 0; j < 3; j++) {
                s.append(puzzle[j][i]);
            }

            boolean isPossible = false;
            for (int j = 0; j < 6; j++) {
                if (!visited2[j]) {
                    if (s.toString().equals(arr[j])) {
                        visited2[j] = true;
                        isPossible = true;
                        break;
                    }

                }
            }

            if (!isPossible) return false;
        }

        return true;
    }

    private void dfs(int level) {
        if (level == 3) {
            makingPuzzle();

            if (isPossible()) {
                output(1);
                System.exit(0);
            }

            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                nums.add(i);
                visited[i] = true;
                dfs(level + 1);
                visited[i] = false;
                nums.remove(nums.size() - 1);
            }
        }

    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 6; i++) {
            String s = br.readLine();
            arr[i] = s;
        }
    }


}