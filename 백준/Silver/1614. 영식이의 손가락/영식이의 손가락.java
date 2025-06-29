import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int fingerNum;
    private int limit;

    public void solution() throws IOException {
        input();
        output(getMaxCnt());
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private long getMaxCnt() {
        if (fingerNum == 1 && limit == 0) {
            return 0;
        }

        long answer = 0;
        long tmp = limit + 1;

        if (fingerNum == 1) {
            answer = 8 * tmp - 7 - 1;

        } else if (fingerNum == 2) {
            if (tmp % 2 == 0) {
                answer = 8 * tmp / 2 - 1;
            } else {
                answer = 8 * ((tmp + 1) / 2) - 6 - 1;
            }

        } else if (fingerNum == 3) {
            answer = 4 * tmp - 2;

        } else if (fingerNum == 4) {
            if (tmp % 2 == 0) {
                answer = 8 * tmp / 2 - 2 - 1;
            } else {
                answer = 8 * ((tmp + 1) / 2) - 4 - 1;
            }

        } else {
            answer = 8 * tmp - 4;
        }

        return answer;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fingerNum = Integer.parseInt(br.readLine());
        limit = Integer.parseInt(br.readLine());
    }
}