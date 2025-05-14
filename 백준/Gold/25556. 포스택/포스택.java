import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arr = new ArrayList<>();
    private ArrayList<Integer> A = new ArrayList<>();
    private ArrayList<Integer> B = new ArrayList<>();
    private ArrayList<Integer> C = new ArrayList<>();
    private ArrayList<Integer> D = new ArrayList<>();

    public void solution() throws IOException {
        input();

        if (isPossible()) {
            output("YES");
        }else output("NO");
    }

    private boolean isPossible() {
        for (int i = 0; i < N; i++) {
            int num = arr.get(i);

            if (i == 0) {
                A.add(num);
                continue;
            }

            int j = 0;

            if (A.get(A.size() - 1) < num) {
                A.add(num);
                continue;
            }

            if (B.isEmpty()) {
                B.add(num);
                continue;
            } else if (B.get(B.size() - 1) < num) {
                B.add(num);
                continue;
            }

            if (C.isEmpty()) {
                C.add(num);
                continue;
            } else if (C.get(C.size() - 1) < num) {
                C.add(num);
                continue;
            }

            if (D.isEmpty()) {
                D.add(num);
                continue;
            } else if (D.get(D.size() - 1) < num) {
                D.add(num);
                continue;
            }

            return false;
        }

        return true;
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
    }
}