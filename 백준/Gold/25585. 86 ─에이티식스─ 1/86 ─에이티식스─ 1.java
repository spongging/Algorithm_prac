import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 201;
    static final int INF = 2000000000;
    static int N;
    static int[][] MAP = new int[MAX][MAX];
    static Pair Home;
    static ArrayList<Pair> enemyList = new ArrayList<>();
    static int Answer = INF;

    static class Pair implements Comparable<Pair> {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        // C++의 pair 정렬 기준: first가 같으면 second로 비교
        @Override
        public int compareTo(Pair o) {
            if (this.first == o.first)
                return this.second - o.second;
            return this.first - o.first;
        }
    }

    // 입력 처리: i, j 좌표를 변환하여 MAP에 저장하며, 레기온(1)과 시작점(2)을 기록
    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                // 변환된 좌표
                int r = i + j;
                int c = (N - 1 - i) + j;
                MAP[r][c] = val;
                if (val == 1) {
                    enemyList.add(new Pair(r, c));
                } else if (val == 2) {
                    Home = new Pair(r, c);
                }
            }
        }
    }

    // 모든 레기온(Enemy) 방문 순서를 완전 탐색(순열)하며 이동 가능 여부와 시간을 계산
    static void generatePermutations(ArrayList<Pair> perm, boolean[] used) {
        if (perm.size() == enemyList.size()) {
            int nowY = Home.first;
            int nowX = Home.second;
            boolean finish = true;
            int time = 0;
            for (Pair enemy : perm) {
                int subY = Math.abs(nowY - enemy.first);
                int subX = Math.abs(nowX - enemy.second);
                // 저거노트는 대각선으로만 이동하므로, 두 좌표 차이가 모두 짝수여야 함
                if (subY % 2 == 0 && subX % 2 == 0) {
                    time += (subY + subX);
                    nowY = enemy.first;
                    nowX = enemy.second;
                } else {
                    finish = false;
                    break;
                }
            }
            if (finish) {
                Answer = Math.min(Answer, time / 2);
            }
            return;
        }
        for (int i = 0; i < enemyList.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                perm.add(enemyList.get(i));
                generatePermutations(perm, used);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader, PrintWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        input(br);
        
        // 레기온이 하나도 없으면 바로 Answer = 0
        if (enemyList.isEmpty()) {
            Answer = 0;
        } else {
            // 순열 생성을 위해 정렬 (C++ 코드와 동일하게)
            Collections.sort(enemyList);
            boolean[] used = new boolean[enemyList.size()];
            ArrayList<Pair> perm = new ArrayList<>();
            generatePermutations(perm, used);
        }
        
        if (Answer == INF) {
            out.println("Shorei");
        } else {
            out.println("Undertaker");
            out.println(Answer);
        }
        out.flush();
        out.close();
    }
}
