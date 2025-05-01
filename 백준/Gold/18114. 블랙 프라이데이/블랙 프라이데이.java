import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, C;
    private ArrayList<Integer> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();

        if (findingOneElement()) {
            output(1);
        } else if (findingTwoElement()) {
            output(1);
        } else if (findingThreeElement()) {
            output(1);
        } else {
            output(0);
        }
    }

    private boolean findingOneElement() {
        for (int num : arr) {
            if (num == C) {
                return true;
            }
        }

        return false;
    }

    private boolean findingTwoElement() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr.get(i) + arr.get(j) == C) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findingThreeElement() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = C - arr.get(i) - arr.get(j);

                if (binarySearch(target, j + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean binarySearch(int target, int start) {
        int st = start;
        int ed = N - 1;

        while (st <= ed) {
            int mid = (st + ed) / 2;

            if (arr.get(mid) < target) {
                st = mid + 1;
            } else if (arr.get(mid) == target) {
                return true;
            } else {
                ed = mid - 1;
            }
        }

        return false;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line2[i]));
        }

        Collections.sort(arr);
    }
}
