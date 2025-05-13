import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Pair> works = new ArrayList<>();
    private ArrayList<Pair> groupPair = new ArrayList<>();

    public void solution() throws IOException {
        input();
        grouping();
        output(cal());
    }

    private void output(int answer) {
        System.out.println(answer);
    }


    private int cal() {
        int total = 0;

        for (Pair p : groupPair) {
            ArrayList<Pair> sub = new ArrayList<>();

            for (Pair p2 : works) {
                if (p.getSt() <= p2.getSt() && p.getEd() >= p2.getEd()) {
                    sub.add(new Pair(p2.getSt(), p2.getEd()));
                }
            }

            int maxOverlap = 0;

            for (int i = 1; i <= 365; i++) {
                int overlap = 0;

                for (Pair sp : sub) {
                    if (sp.getSt() <= i && i <= sp.getEd()) {
                        overlap++;
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }

            total += ((maxOverlap) * (p.getEd() - p.getSt() + 1));
        }

        return total;
    }

    private void grouping() {
        int curSt;
        int curEd;

        Pair p = works.get(0);
        curSt = p.getSt();
        curEd = p.getEd();

        for (int i = 1; i < works.size(); i++) {
            Pair p2 = works.get(i);

            if (curEd + 1 >= p2.getSt()) {
                curEd = Math.max(curEd, p2.getEd()); // max
            } else {
                groupPair.add(new Pair(curSt, curEd));
                curSt = p2.getSt();
                curEd = p2.getEd();
            }
        }

        groupPair.add(new Pair(curSt, curEd));
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            works.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        works.sort(Comparator
                .comparingInt(Pair::getSt)
                .thenComparingInt(Pair::getEd));
    }
}

class Pair {
    private int st;
    private int ed;

    public Pair(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }

    public int getSt() {
        return st;
    }

    public int getEd() {
        return ed;
    }
}

