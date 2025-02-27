import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[] arr;

    public void solution() throws IOException {
        input();
        if (arr.length == 1) {
            output(0);
            return;
        }

        int answerOfAsc = makeCorrectSequence(true);
        int answerOfDesc = makeCorrectSequence(false);

        if (answerOfDesc == answerOfAsc && answerOfDesc == -1) {
            output(-1);
            return;
        }

        if (answerOfDesc == -1) {
            output(answerOfAsc);
        } else if (answerOfAsc == -1) {
            output(answerOfDesc);
        } else {
            output(Math.min(answerOfDesc, answerOfAsc));
        }
    }

    private int makeCorrectSequence(boolean flag) {
        int boundaryIdx = findBoundaryIdx(flag);
        if (boundaryIdx == 0) {
            return 0;
        }

        boolean flag2 = true;
        for (int i = 0; i <= boundaryIdx - 2; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    flag2 = false;
                    break;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    flag2 = false;
                    break;
                }
            }
        }

        if (!flag2) return -1;

        if (flag) {
            if (arr[arr.length - 1] <= arr[0]) {
                return boundaryIdx;
            } else {
                return -1;
            }
        } else {
            if (arr[arr.length - 1] >= arr[0]) {
                return boundaryIdx;
            } else {
                return -1;
            }
        }
    }

    private int findBoundaryIdx(boolean flag) {
        int boundaryIdx = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                return 0;
            }

            int st = i - 1;
            int ed = i;

            if (flag) {
                if (arr[st] > arr[ed]) {
                    boundaryIdx = ed;
                    break;
                }
            } else {
                if (arr[st] < arr[ed]) {
                    boundaryIdx = ed;
                    break;
                }
            }
        }

        return boundaryIdx;
    }

    private boolean judgement() {
        int num1 = arr[arr.length - 2];
        int num2 = arr[arr.length - 1];

        return num1 <= num2;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
    }

    private void output(int answer) {
        System.out.println(answer);
    }
}
