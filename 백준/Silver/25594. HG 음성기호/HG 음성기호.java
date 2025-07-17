import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final Map<Character, String> map = new HashMap<>();

    public void solution() throws IOException {
        init();
        isAppropriate(input());
    }

    private void isAppropriate(String s) {
        int st = 0;
        int ed;
        StringBuilder answer = new StringBuilder();

        while (true) {
            if (st == s.length()) {
                break;
            }


            char c = s.charAt(st);
            int len = map.get(c).length();

            if (st + len > s.length()) {
                System.out.println("ERROR!");
                return;
            }
            ed = st + len - 1;

            String tmp = "";

            for (int i = st; i <= ed; i++) {
                tmp += s.charAt(i);
            }

            if (tmp.equals(map.get(c))) {
                st = ed + 1;
                answer.append(c);
            } else {
                System.out.println("ERROR!");
                return;
            }
        }

        System.out.println("It's HG!");
        System.out.println(answer);
    }

    private String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private void init() {
        map.put('a', "aespa");
        map.put('b', "baekjoon");
        map.put('c', "cau");
        map.put('d', "debug");
        map.put('e', "edge");
        map.put('f', "firefox");
        map.put('g', "golang");
        map.put('h', "haegang");
        map.put('i', "iu");
        map.put('j', "java");
        map.put('k', "kotlin");
        map.put('l', "lol");
        map.put('m', "mips");
        map.put('n', "null");
        map.put('o', "os");
        map.put('p', "python");
        map.put('q', "query");
        map.put('r', "roka");
        map.put('s', "solvedac");
        map.put('t', "tod");
        map.put('u', "unix");
        map.put('v', "virus");
        map.put('w', "whale");
        map.put('x', "xcode");
        map.put('y', "yahoo");
        map.put('z', "zebra");
    }
}