import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[][] arr = new int[19][19];
    private boolean flag = true; // true 흑 false 백
    private int cnt = 0;
    private ArrayList<Pair> pairs = new ArrayList<>();

    public void solution() throws IOException {
        output(inputAndSolution());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            pairs.add(new Pair(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1));
        }
    }

    private int inputAndSolution() throws IOException {
        input();

        for (Pair p : pairs) {

            int a = p.getA();
            int b = p.getB();

            cnt++;

            if (flag) {
                arr[a][b] = 1;
            } else {
                arr[a][b] = 2;
            }

            if (checkWidth(a, b)) {
                return cnt;
            } else if (checkLength(a, b)) {
                return cnt;
            } else if (checkDiagonal(a, b)) {
                return cnt;
            }

            flag = !flag;
        }

        return -1;
    }

    private boolean checkWidth(int a, int b) {
        int initA = a;
        int initB = b;

        int continuousCnt = 0;

        while (true) { // 가로 왼쪽 방향 탐색
            if (b < 0) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            b--;
        }

        a = initA;
        b = initB;
        continuousCnt--;

        while (true) {
            if (b > 18) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            b++;
        }

        return continuousCnt == 5;
    }

    private boolean checkLength(int a, int b) {
        int initA = a;
        int initB = b;

        int continuousCnt = 0;

        while (true) { // 새로 위쪽 방향 탐색
            if (a < 0) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a--;
        }

        a = initA;
        b = initB;
        continuousCnt--;

        while (true) { // 새로 위쪽 방향 탐색
            if (a > 18) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a++;
        }

        return continuousCnt == 5;
    }

    private boolean checkDiagonal(int a, int b) {

        if (topLeftToBottomRight(a, b)) {
            return true;
        } else if (topRightToBottomLeft(a, b)) {
            return true;
        }

        return false;
    }

    private boolean topLeftToBottomRight(int a, int b) {
        int initA = a;
        int initB = b;

        int continuousCnt = 0;

        while (true) { // 대각선 위쪽 방향 탐색
            if (a < 0 || b < 0) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a--; b--;
        }

        a = initA;
        b = initB;
        continuousCnt--;

        while (true) { // 새로 위쪽 방향 탐색
            if (a > 18 || b > 18) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a++; b++;
        }

        return continuousCnt == 5;
    }

    private boolean topRightToBottomLeft(int a, int b) {
        int initA = a;
        int initB = b;

        int continuousCnt = 0;

        while (true) { // 대각선 위쪽 방향 탐색
            if (a < 0 || b > 18) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a--; b++;
        }

        a = initA;
        b = initB;
        continuousCnt--;

        while (true) { // 새로 위쪽 방향 탐색
            if (a > 18 || b < 0) {
                break;
            }

            if (flag) { // 흑
                if (arr[a][b] == 1) {
                    continuousCnt++;
                } else {
                    break;
                }
            } else {
                if (arr[a][b] == 2) {
                    continuousCnt++;
                } else {
                    break;
                }
            }

            a++; b--;
        }

        return continuousCnt == 5;
    }
}

class Pair {
    private int a;
    private int b;

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
