import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arr = new ArrayList<>();
    private int[] arrowCnt;

    public void solution() throws IOException {
        input();
        output(getArrowCnt());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getArrowCnt() {
        int cnt = 0;

        for (int height : arr) {
            if (arrowCnt[height + 1] > 0) {
                arrowCnt[height + 1]--;
            } else {
                cnt++;
            }

            arrowCnt[height]++;
        }

        return cnt;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arrowCnt = new int[1000002];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
    }
}