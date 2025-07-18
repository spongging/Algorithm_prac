import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int T, cnt = 1;
    private int N,S, P;

    private final ArrayList<Integer> arr = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine().trim());

        while (cnt <= T) {
            int counting = 0;
            input();

            for (int num : arr) {
                if (isSatisfied(num)) {
                    counting++;
                }
            }

            output(counting, cnt);
            cnt++;
        }
    }

    private void output(int counting, int cnt) {
        System.out.println("Case #" + cnt + ":" + " " + counting);
    }

    private boolean isSatisfied(int num) {
        int quot = num / 3;
        int remain = num % 3;


        if (num == 0 || num == 1) {
            return num >= P; 
        }
        
        if (remain == 0) {
            if (quot >= P) {
                return true;
            }

            if (S > 0 && quot + 1 >= P) {
                S--;
                return true;
            }

        } else if (remain == 1) {
            if (quot + 1 >= P) {
                return true;
            }

        } else {
            if (quot + 1 >= P) {
                return true;
            }

            if (S > 0 && quot + 2 >= P) {
                S--;
                return true;
            }
        }

        return false;
    }

    private void input() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        P = Integer.parseInt(line[2]);
        arr.clear();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(line[i + 3]));
        }
    }
}