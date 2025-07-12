import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Long> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        if (N == 1 || N == 2) {
            output(N);
            return;
        }
        output(getMaxLength());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int getMaxLength() {
        int maxLength = 0;

        for (int i = 0; i <= arr.size() - 3; i++) {
            int tmpLength = 2;
            int st = i;
            int ed = i + 1;

            for (int j = i + 2; j < arr.size(); j++) {
                int target = j;

                if (arr.get(st) + arr.get(ed) > arr.get(target)) {
                    tmpLength++;
                    if (j == arr.size() - 1) {
                        maxLength = Math.max(maxLength, tmpLength);
                    }
                } else {
                    maxLength = Math.max(maxLength, tmpLength);
                    break;
                }
            }
        }

        return maxLength;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr.add(Long.parseLong(line[i]));
        }

        Collections.sort(arr);
    }
}