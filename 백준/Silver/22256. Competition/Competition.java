import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int a,b, n;

    private ArrayList<Integer> arra = new ArrayList<>();
    private ArrayList<Integer> arrb = new ArrayList<>();
    private ArrayList<Integer> delta = new ArrayList<>();
    
    public void solution() throws IOException {
        input();
        output(getTotal());
    }

    private long getTotal() {
        long sumB = 0;

        for (int i = 0; i < arrb.size(); i++) {
            sumB += arrb.get(i);
        }

        for (int i = 0; i < n; i++) {
            delta.add(arra.get(i) - arrb.get(i));
        }

        delta.sort(Comparator.reverseOrder());

        for (int i = 0; i < a; i++) {
            sumB += delta.get(i);
        }

        return sumB;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        a = Integer.parseInt(line[1]);
        b = Integer.parseInt(line[2]);

        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arra.add(Integer.parseInt(line2[i]));
        }

        String[] line3 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrb.add(Integer.parseInt(line3[i]));
        }
    }
}