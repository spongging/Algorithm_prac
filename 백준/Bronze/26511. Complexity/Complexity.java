import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int n;
    private int[] alpha;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        input();

        while (n > 0) {
            String s = br.readLine();

            getCountOfAlphabet(s);
            output(getEraseCount(s));

            n--;
        }
    }

    private int getEraseCount(String s) {
        int cnt = 0;
        for (int i = alpha.length - 3; i >= 0; i--) {
            if (alpha[i] > 0) {
                cnt += alpha[i];
            }
        }

        return cnt;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void getCountOfAlphabet(String s) {
        alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alpha[c-'a']++;
        }

        Arrays.sort(alpha);
    }

    private void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}