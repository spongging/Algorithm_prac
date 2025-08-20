import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private Set<Integer> s1;
    private ArrayList<Integer> memo;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final StringBuilder out = new StringBuilder();

    public void solution() throws IOException {
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            input();
            getAnswer();
        }

        System.out.print(out);
    }

    private void getAnswer() {
        for (int n : memo) {
            if (s1.contains(n)) output(1);
            else output(0);
        }
    }

    private void output(int answer) {
        out.append(answer).append('\n');
    }

    private void input() throws IOException {
        s1 = new HashSet<>();
        memo = new ArrayList<>();

        N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s1.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            memo.add(Integer.parseInt(st.nextToken()));
        }
    }
}
