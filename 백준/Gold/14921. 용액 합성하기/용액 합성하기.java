import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arr = new ArrayList<>();
    private int answer = Integer.MAX_VALUE;

    public void solution() throws IOException {
        input();
        findLiquid();
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void findLiquid() {
        int st = 0;
        int ed = arr.size() - 1;

        while (st < ed) {
            int stNum = arr.get(st);
            int edNum = arr.get(ed);
            int sum = stNum + edNum;


            if (sum == 0) {
                answer = sum;
                break;
            } else if (sum > 0) {
                ed--;
            } else {
                st++;
            }

            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
    }
}