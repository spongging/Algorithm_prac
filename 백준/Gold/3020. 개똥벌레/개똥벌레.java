import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int H;
    private int[] upArr;
    private int[] downArr;
    private int minConflict = Integer.MAX_VALUE;
    private int cnt = 0;

    public void solution() throws IOException {
        input();
        for (int i = 1; i <= H; i++) {
            int conflict = 0;
            conflict += binarySearch(0, N / 2 - 1, i, downArr) + binarySearch(0, N / 2 - 1, H - i + 1, upArr);

            if (conflict == minConflict) {
                cnt++;
                continue;
            }

            if (conflict < minConflict) {
                minConflict = conflict;
                cnt = 1;
            }
        }
        output();
    }

    private void output() {
        System.out.println(minConflict + " " + cnt);
    }

    private int binarySearch(int st, int ed, int h, int[] arr) {
        while (st <= ed) {
            int mid = (st + ed) / 2;

            if (arr[mid] >= h) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return arr.length - st;
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]);

        upArr = new int[N / 2];
        downArr = new int[N / 2];

        for (int i = 0; i < N / 2 ; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            downArr[i] = a;
            upArr[i] = b;
        }

        Arrays.sort(downArr);
        Arrays.sort(upArr);
    }
}