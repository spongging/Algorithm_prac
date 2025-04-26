import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private String W;
    private int g, s;
    private String S;
    private HashMap<Character, Integer> m1 = new HashMap<>();
    private HashMap<Character, Integer> m2 = new HashMap<>();

    public void solution() throws IOException {
        input();
        countingCharOfW();
        output(deciphering());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int deciphering() {
        int cnt = 0;
        int st = 0;
        int ed = g - 1;

        for (int i = 0; i < g; i++) {
            char c = S.charAt(i);
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        if (isEqual()) {
            cnt++;
        }

        while (true) {
            m2.put(S.charAt(st), m2.get(S.charAt(st)) - 1);
            if (m2.get(S.charAt(st)).equals(0)) {
                m2.remove(S.charAt(st));
            }

            st++;
            ed++;

            if (ed == s) {
                break;
            }

            m2.put(S.charAt(ed), m2.getOrDefault(S.charAt(ed), 0) + 1);

            if (isEqual()) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean isEqual() {
        return m1.equals(m2);
    }

    private void countingCharOfW() {
        for (int i = 0; i < W.length(); i++) {
            char c = W.charAt(i);
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        g = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);

        W = br.readLine();
        S = br.readLine();
    }
}