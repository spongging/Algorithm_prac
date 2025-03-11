import javax.swing.*;
import java.io.*;
import java.net.Inet4Address;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int[] answerArr = new int[2];
    private int minDiff = Integer.MAX_VALUE;

    public void solution() throws IOException{
        input();
        findLiquid();
        output();
    }

    private void output() {
        System.out.println(answerArr[0] + " " + answerArr[1]);
    }

    private void findLiquid() {
        int st = 0;
        int ed = arrayList.size() - 1;

        while (st < ed) {
            int sum = arrayList.get(st) + arrayList.get(ed);

            if (sum > 0) {
                if (check(sum)) {
                    minDiff = Math.abs(sum);
                    answerArr[0] = arrayList.get(st);
                    answerArr[1] = arrayList.get(ed);
                }
                ed--;
            } else if (sum == 0) {
                answerArr[0] = arrayList.get(st);
                answerArr[1] = arrayList.get(ed);
                break;

            } else {
                if (check(sum)) {
                    minDiff = Math.abs(sum);
                    answerArr[0] = arrayList.get(st);
                    answerArr[1] = arrayList.get(ed);
                }
                st++;
            }
        }
    }

    private boolean check(int sum) {
        return Math.abs(sum) < minDiff;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        String[] line = br.readLine().split(" ");

        for (String s : line) {
            arrayList.add(Integer.parseInt(s));
        }
    }
}