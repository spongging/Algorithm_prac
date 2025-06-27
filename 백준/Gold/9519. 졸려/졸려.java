import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int X;
    private String initS;
    private Stack<String> s = new Stack<>();
    private String cur;
    private int cnt = 0;

    public void solution() throws IOException {
        input();

        cur = initS;

        while (true) {
            String next = mixing(cur);
            cnt++;

            if (next.equals(initS)) {
                break;
            }

            s.add(next);
            cur = next;
        }

        output(getPreviousString());
    }

    private void output(String s) {
        System.out.println(s);
    }

    private String getPreviousString() {
        int remainder = X % cnt;
        String result = null;

        for (int i = 1; i <= remainder; i++) {
            String pop = s.pop();

            if (i == remainder) {
                result = pop;
            }
        }

        if (cnt == 1) {
            return initS;
        }
        
        return result;
    }

    private String mixing(String s) {
        StringBuilder tmp = new StringBuilder();
        int st = 0;
        int ed = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                tmp.append(s.charAt(st++));
            } else {
                tmp.append(s.charAt(ed--));
            }
        }

        return tmp.toString();
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        initS = br.readLine();

        s.add(initS);
    }
}