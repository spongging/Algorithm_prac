import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private String S;
    private int Q;

    private final ArrayList<Query> queries = new ArrayList<>();
    private int[][] dp;

    private final StringBuilder sb = new StringBuilder(1 << 20);

    public void solution() throws IOException {
        input();
        executeDp();

        for (Query q : queries) {
            output(getAnswer(q));   
        }

        System.out.print(sb);
    }

    private int getAnswer(Query q) {
        return dp[q.getC() - 'a'][q.getEd()]
                - (q.getSt() > 0 ? dp[q.getC() - 'a'][q.getSt() - 1] : 0);
    }

    private void output(int answer) {
        sb.append(answer).append('\n');
    }

    private void executeDp() {
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            dp[c - 'a'][i] = 1;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < S.length(); j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

        S = br.readLine();
        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int stIdx = Integer.parseInt(st.nextToken());
            int edIdx = Integer.parseInt(st.nextToken());
            queries.add(new Query(c, stIdx, edIdx));
        }

        dp = new int[26][S.length()];
    }
}


class Query {
    private final char c;
    private final int st;
    private final int ed;

    public Query(char c, int st, int ed) {
        this.c = c;
        this.st = st;
        this.ed = ed;
    }

    public char getC() {
        return c;
    }

    public int getSt() {
        return st;
    }

    public int getEd() {
        return ed;
    }
}