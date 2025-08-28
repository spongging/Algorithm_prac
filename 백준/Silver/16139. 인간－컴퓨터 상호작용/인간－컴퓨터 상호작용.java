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

    public void solution() throws IOException {
        input();
        executeDp();

        for (Query q : queries) {
            output(getAnswer(q));
        }
    }

    private int getAnswer(Query q) {
        return dp[q.getC() - 'a'][q.getEd()] - (q.getSt() > 0 ? dp[q.getC() - 'a'][q.getSt() - 1] : 0);
    }

    private void output(int answer) {
        System.out.println(answer);
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().trim();
        Q = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < Q; i++) {
            String[] line = br.readLine().split(" ");
            queries.add(new Query(line[0].charAt(0), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
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