import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, Q;
    private ArrayList<Integer> colors = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int total = 0;
    private ArrayList<Integer> answerList = new ArrayList<>();


    public void solution() throws IOException {
        input();
        init();
        eat();
        getTotalAndColorList();
        output();
    }

    private void output() {
        System.out.println(total);

        if (total == 0) {
            return;
        }

        for (int color : answerList) {
            System.out.print(color + " ");
        }
    }

    private void getTotalAndColorList() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer color = entry.getKey();

            total += value;

            for (int i = 0; i < value; i++) {
                answerList.add(color);
            }
        }
    }

    private void init() {
        for (int color : colors) {
            if (map.containsKey(color)) {
                Integer i = map.get(color);
                map.put(color, i + 1);
            } else {
                map.put(color, 1);
            }
        }
    }

    private void eat() throws IOException {
        String[] line1;
        String[] line2;

        while (Q > 0) {
            line1 = br.readLine().split(" ");
            line2 = br.readLine().split(" ");

            if (eatIfPossible(line1)) {
                addIcecream(line2);
            }

            Q--;
        }
    }

    private void addIcecream(String[] s) {
        int n = s.length - 1;

        for (int i = 1; i <= n; i++) {
            int color = Integer.parseInt(s[i]);
            map.put(color, map.getOrDefault(color, 0) + 1);
        }
    }

    private boolean eatIfPossible(String[] s) {
        boolean flag = true;
        ArrayList<Integer> tmpArr = new ArrayList<>();
        Map<Integer, Integer> tmpMap = new HashMap<>();
        int n = s.length - 1;

        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                n = Integer.parseInt(s[i]);
            } else {
                tmpArr.add(Integer.parseInt(s[i]));
            }
        }

        for (int i = 0; i < n; i++) {
            int color = tmpArr.get(i);

            if (tmpMap.containsKey(color)) {
                Integer i1 = tmpMap.get(color);
                tmpMap.put(color, i1 + 1);
            } else {
                tmpMap.put(color, 1);
            }
        }

        // 비교

        for (int color : tmpArr) {
            int have = map.getOrDefault(color, 0);
            int need = tmpMap.get(color);
            if (have < need) {
                return false;
            }
        }

        if (flag) {
            for (Map.Entry<Integer, Integer> entry : tmpMap.entrySet()) {
                int color = entry.getKey();
                int value = entry.getValue();

                Integer i = map.get(color);
                map.put(color, i - value);
            }
        }

        return flag;
    }

    private void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            colors.add(Integer.parseInt(line[i]));
        }

        Q = Integer.parseInt(br.readLine());
    }
}