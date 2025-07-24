import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private String s;
    private int num = 1;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (true) {
            input();
            if (s.charAt(0) == '-') {
                break;
            }

            output(getAnswer());
            num++;
        }
    }

    private void output(int answer) {
        System.out.println(num + "." + " " + answer);
    }

    private int getAnswer() {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    cnt++;
                } else {
                    stack.pop();
                }
            }
        }

        return (int) Math.ceil(stack.size() / 2.0) + (int) Math.ceil(cnt / 2.0);
    }

    private void input() throws IOException {
        s = br.readLine();
    }
}