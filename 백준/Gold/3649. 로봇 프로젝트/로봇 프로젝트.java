import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int x, n;
    private int st, ed;

    private final ArrayList<Integer> arr = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (input()) {
            if (isPossible()) {
                System.out.println("yes " + arr.get(st) + " " + arr.get(ed));
            } else {
                System.out.println("danger");
            }
        }
    }

    private boolean isPossible() {
        st = 0;
        ed = arr.size() - 1;

        while (st < ed) {
            int n1 = arr.get(st);
            int n2 = arr.get(ed);

            if (n1 + n2 < x) {
                st++;
            } else if (n1 + n2 > x) {
                ed--;
            } else {
                return true;
            }
        }

        return false;
    }

    private boolean input() throws IOException {
        String line = br.readLine();

        if (line == null) {
            return false;
        }

        x = Integer.parseInt(line.trim()) * 10000000;
        n = Integer.parseInt(br.readLine().trim());
        arr.clear();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine().trim()));
        }

        Collections.sort(arr);

        return true;
    }
}