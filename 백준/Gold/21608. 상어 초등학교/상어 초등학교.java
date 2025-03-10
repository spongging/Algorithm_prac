import javax.swing.*;
import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<ArrayList<Integer>> loveArr = new ArrayList<>();
    private ArrayList<Integer> sequence = new ArrayList<>();
    private ArrayList<Pair> pairs; // 조건 1의 앉을 수 있는 후보 자리의 좌표 저장
    private ArrayList<Pair> pairs2; // 조건 1 and 조건 2의 앉을 수 있는 후보 자리의 좌표 저장
    private int[][] map;

    public void solution() throws IOException {
        input();

        for (int i = 0; i < sequence.size(); i++) {
            searchingLoveStudent(sequence.get(i));

            if (pairs.size() == 1) {
                Pair pair = pairs.get(0);

                map[pair.getA()][pair.getB()] = sequence.get(i);
                continue;
            } else if (pairs.size() > 1) {
                searchingBlankSeat();
            } else {
                continue;
            }

            if (pairs2.size() == 1) {
                Pair pair = pairs2.get(0);

                map[pair.getA()][pair.getB()] = sequence.get(i);
            } else {
                pairs2.sort((p1, p2) -> {
                    if (p1.getA() != p2.getA()) {
                        return Integer.compare(p1.getA(), p2.getA());
                    }
                    return Integer.compare(p1.getB(), p2.getB());
                });

                Pair pair = pairs2.get(0);
                map[pair.getA()][pair.getB()] = sequence.get(i);
            }
        }

        output(calSatisfaction());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private int calSatisfaction() {
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                int key = map[i][j];

                for (int k = 0; k < 4; k++) {
                    int na = i + da[k];
                    int nb = j + db[k];

                    if (na >= 0 && na < N && nb >= 0 && nb < N) {
                        if (loveArr.get(key).contains(map[na][nb])) {
                            cnt++;
                        }
                    }
                }

                if (cnt == 0) {
                    continue;
                } else if (cnt == 1) {
                    sum+=cnt;
                } else if (cnt == 2) {
                    sum += 10;
                } else if (cnt == 3) {
                    sum += 100;
                } else {
                    sum += 1000;
                }
            }
        }

        return sum;
    }

    private void searchingBlankSeat() {
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};
        int maxBlankCnt = 0;
        pairs2 = new ArrayList<>();

        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);

            int aa = p.getA();
            int bb = p.getB();
            int blankCnt = 0;

            for (int j = 0; j < 4; j++) {
                int na = aa + da[j];
                int nb = bb + db[j];

                if (na >= 0 && na < N && nb >= 0 && nb < N) {
                    if (map[na][nb] == 0) {
                        blankCnt++;
                    }
                }
            }

            if (blankCnt == maxBlankCnt) {
                pairs2.add(new Pair(aa, bb));
            } else if (blankCnt > maxBlankCnt) {
                maxBlankCnt = blankCnt;
                pairs2.clear();
                pairs2.add(new Pair(aa, bb));
            }
        }
    }

    private void searchingLoveStudent(int studentNum) {
        int maxCnt = 0;
        pairs = new ArrayList<>();
        ArrayList<Integer> listOfLove = loveArr.get(studentNum); // 해당 학생이 좋아하는 학생 리스트

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]!=0) continue;

                int cnt = countingAdjacencyStudent(i, j, listOfLove);

                if (cnt == maxCnt) {
                    pairs.add(new Pair(i, j));
                } else if (maxCnt < cnt) {
                    maxCnt = cnt;
                    pairs.clear();
                    pairs.add(new Pair(i, j));
                }
            }
        }
    }

    private int countingAdjacencyStudent(int a, int b, ArrayList<Integer> listOfLove) {
        int cnt = 0;
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && na < N && nb >= 0 && nb < N) {
                if (listOfLove.contains(map[na][nb])) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N * N; i++) {
            loveArr.add(new ArrayList<>());
        }

        for (int i = 0; i < N * N; i++) {
            String[] line = br.readLine().split(" ");

            int key = Integer.parseInt(line[0]);
            sequence.add(key);
            ArrayList<Integer> tempList = loveArr.get(key);

            for (int j = 1; j < 5; j++) {
                tempList.add(Integer.parseInt(line[j]));
            }
        }

        map = new int[N][N];
    }
}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}