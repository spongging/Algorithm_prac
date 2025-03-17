import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[] arr = new int[26];
    private int num = 9;
    private int answer = 0;

    public void solution() throws IOException {
        inputAndFind();
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void inputAndFind() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                arr[c - 'A'] += (int) Math.pow(10, line.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i] * num;
            num--;
        }
    }
}
