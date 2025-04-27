import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        output(hacking());
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private long hacking() {
        ArrayList<Integer> tmpArr = new ArrayList<>();
        long cnt = 0;

        int firstNum = arr.get(0);
        int tmp = firstNum - 1;

        cnt += tmp;
        tmpArr.add(firstNum - tmp);

        for (int i = 1; i < N; i++) {
            int b = arr.get(i);
            int a = tmpArr.get(i - 1);
            int x = Math.max(b - a - 1, 0);

            cnt += x;

            tmpArr.add(b - x);
        }

        return cnt;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }

        Collections.sort(arr);
    }
}