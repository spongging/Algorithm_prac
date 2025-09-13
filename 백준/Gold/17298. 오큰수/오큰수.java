import java.util.*;
import java.io.*;

public class Main { // 파일명은 haha.java
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final ArrayList<Integer> arr = new ArrayList<>();
    private final ArrayList<Integer> answerArr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        getAnswer();   // 기존 로직 그대로
        output();      // StringBuilder로 한 번에
    }

    private void output() throws IOException {
        StringBuilder sb = new StringBuilder(answerArr.size() * 3);
        for (int i = answerArr.size() - 1; i >= 0; i--) {
            sb.append(answerArr.get(i)).append(' ');
        }
        System.out.print(sb.toString());
    }

    private void getAnswer() { // 그대로
        Stack<Integer> s = new Stack<>();

        s.add(arr.get(arr.size() - 1));
        answerArr.add(-1);

        for (int i = arr.size() - 2; i >= 0; i--) {
            int tmp = arr.get(i);

            while (true) {
                if (s.isEmpty()) {
                    answerArr.add(-1);
                    break;
                }
                int top = s.peek();
                if (tmp < top) {
                    answerArr.add(top);
                    break;
                } else {
                    s.pop();
                }
            }
            s.add(tmp);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N
        N = Integer.parseInt(br.readLine().trim());

        // 둘째 줄 이후에서 N개 토큰을 안전하게 읽기(줄바꿈 있어도 OK)
        StringTokenizer st = null;
        while (arr.size() < N) {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break; // 방어
                st = new StringTokenizer(line);
                if (!st.hasMoreTokens()) continue;
            }
            arr.add(Integer.parseInt(st.nextToken()));
        }
    }
}
