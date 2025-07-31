import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final long map[][] = new long[8][8];
    private char c;

    public void solution() throws IOException {
        input();
        execute();
        output();
    }

    private void execute() {
        boolean[][] merged = new boolean[8][8]; // 한 번의 이동에서 이미 합쳐진 위치 표시

        if (c == 'U') {
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if (map[i][j] != 0) {
                        long cur = map[i][j];

                        for (int k = i - 1; k >= 0; k--) {
                            long tmp = map[k][j];

                            if (tmp == 0) {
                                map[k][j] = cur;
                                map[i][j] = 0;
                                i = k; // 현재 타일이 이동했으므로 기준 위치를 옮겨줘야 다음 비교가 올바름
                            } else if (tmp == cur && !merged[k][j]) {
                                map[i][j] = 0;
                                map[k][j] = cur * 2;
                                merged[k][j] = true; // 한 번 합쳐졌으니 다시 합치지 않게 표시
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            // 나머지 방향도 동일한 방식으로 merged 체크 추가
        } else if (c == 'R') {
            boolean[][] mergedR = merged; // 같은 merged 배열을 방향별로 공유해도 되고, 새로 선언해도 됨
            for (int i = 0; i < 8; i++) {
                for (int j = 7; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        long cur = map[i][j];

                        for (int k = j + 1; k < 8; k++) {
                            long tmp = map[i][k];

                            if (tmp == 0) {
                                map[i][k] = cur;
                                map[i][j] = 0;
                                j = k;
                            } else if (tmp == cur && !mergedR[i][k]) {
                                map[i][j] = 0;
                                map[i][k] = cur * 2;
                                mergedR[i][k] = true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

        } else if (c == 'D') {
            for (int j = 0; j < 8; j++) {
                for (int i = 7; i >= 0; i--) {
                    if (map[i][j] != 0) {
                        long cur = map[i][j];

                        for (int k = i + 1; k < 8; k++) {
                            long tmp = map[k][j];

                            if (tmp == 0) {
                                map[k][j] = cur;
                                map[i][j] = 0;
                                i = k;
                            } else if (tmp == cur && !merged[k][j]) {
                                map[i][j] = 0;
                                map[k][j] = cur * 2;
                                merged[k][j] = true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

        } else { // L
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (map[i][j] != 0) {
                        long cur = map[i][j];

                        for (int k = j - 1; k >= 0; k--) {
                            long tmp = map[i][k];

                            if (tmp == 0) {
                                map[i][k] = cur;
                                map[i][j] = 0;
                                j = k;
                            } else if (tmp == cur && !merged[i][k]) {
                                map[i][j] = 0;
                                map[i][k] = cur * 2;
                                merged[i][k] = true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    private void output() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        c = br.readLine().trim().charAt(0);
    }
}