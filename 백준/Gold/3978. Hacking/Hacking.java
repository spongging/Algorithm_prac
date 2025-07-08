import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T;
    private int n, m, k;
    private String s;
    private String answer;
    private boolean flag;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Set<String> set = new HashSet<>();
    private char[] alpha = new char[26];


    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        initAlphaArr();

        while (T > 0) {
            inputAndInit();
            getSubString();
            output(answer);
            T--;
        }
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private boolean isContain(String s) {
        return set.contains(s);
    }

    private void backTracking(int limit, String tmp) {
        if (flag) return;

        if (tmp.length() == limit) {
            if (!isContain(tmp)) {
                answer = tmp;
                flag = true;
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            backTracking(limit, tmp + alpha[i]);
        }
    }

    private void getSubString() {

        for (int i = 1; i <= m; i++) {
            set.clear();

            for (int j = 0; j <= n - i; j++) {
                set.add(s.substring(j, j + i));
            }

            backTracking(i, "");
            if (flag) break;
        }
    }

    private void inputAndInit() throws IOException {
        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        s = br.readLine();
        flag = false;
    }

    private void initAlphaArr() {
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
        }
    }
}