import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int limitA, limitB, limitC;

    private final ArrayList<Integer> answerArr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        bfs();
        output();
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        limitA = Integer.parseInt(line[0]);
        limitB = Integer.parseInt(line[1]);
        limitC = Integer.parseInt(line[2]);
    }

    private void output() {
        Collections.sort(answerArr);
        for (int n : answerArr) {
            System.out.print(n + " ");
        }
    }

    private void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[201][201][201];

        q.add(new Pair(0, 0, limitC));
        visited[0][0][limitC] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int levelA = p.getLevelA();
            int levelB = p.getLevelB();
            int levelC = p.getLevelC();

            if (levelA == 0) {
                if (!answerArr.contains(levelC)) {
                    answerArr.add(levelC);
                }
            }

            // A가 비어있지 않으면
            if (levelA != 0) {
                int tmpLevelA, tmpLevelB, tmpLevelC, sub;

                // b부터 채움 (A -> B)
                if (levelB + levelA <= limitB) {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    tmpLevelB += tmpLevelA;
                    tmpLevelA = 0;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }
                } else {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    sub = limitB - tmpLevelB;

                    tmpLevelB = limitB;
                    tmpLevelA -= sub;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }

                    if (tmpLevelA + tmpLevelC <= limitC) {
                        tmpLevelC += tmpLevelA;
                        tmpLevelA = 0;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    } else {
                        tmpLevelA -= (limitC - tmpLevelC);
                        tmpLevelC = limitC;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    }
                }

                // c부터 채움 (A -> C)
                if (levelA + levelC <= limitC) {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    tmpLevelC += tmpLevelA;
                    tmpLevelA = 0;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }
                } else {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    sub = limitC - tmpLevelC;

                    tmpLevelC = limitC;
                    tmpLevelA -= sub;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }

                    if (tmpLevelA + tmpLevelB <= limitB) {
                        tmpLevelB += tmpLevelA;
                        tmpLevelA = 0;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    } else {
                        tmpLevelA -= (limitB - tmpLevelB);
                        tmpLevelB = limitB;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    }
                }
            }

            // B가 비어있지 않으면
            if (levelB != 0) {
                int tmpLevelA, tmpLevelB, tmpLevelC, sub;

                // C부터 채움 (B -> C)
                if (levelB + levelC <= limitC) {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    tmpLevelC += tmpLevelB;
                    tmpLevelB = 0;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }
                } else {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    sub = limitC - tmpLevelC;

                    tmpLevelC = limitC;
                    tmpLevelB -= sub;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }

                    if (tmpLevelA + tmpLevelB <= limitA) {
                        tmpLevelA += tmpLevelB;
                        tmpLevelB = 0;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    } else {
                        tmpLevelB -= (limitA - tmpLevelA);
                        tmpLevelA = limitA;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    }
                }

                // A부터 채움 (B -> A)
                if (levelA + levelB <= limitA) {
                    int tmpLevelA2 = levelA;
                    int tmpLevelB2 = levelB;
                    int tmpLevelC2 = levelC;

                    tmpLevelA2 += tmpLevelB2;
                    tmpLevelB2 = 0;

                    if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                        q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                        visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                    }
                } else {
                    int tmpLevelA2 = levelA;
                    int tmpLevelB2 = levelB;
                    int tmpLevelC2 = levelC;

                    int sub2 = limitA - tmpLevelA2;

                    tmpLevelA2 = limitA;
                    tmpLevelB2 -= sub2;

                    if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                        q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                        visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                    }

                    if (tmpLevelC2 + tmpLevelB2 <= limitC) {
                        tmpLevelC2 += tmpLevelB2;
                        tmpLevelB2 = 0;

                        if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                            q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                            visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                        }
                    } else {
                        tmpLevelB2 -= (limitC - tmpLevelC2);
                        tmpLevelC2 = limitC;

                        if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                            q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                            visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                        }
                    }
                }
            }

            // C가 비어있지 않으면
            if (levelC != 0) {
                int tmpLevelA, tmpLevelB, tmpLevelC, sub;

                // b부터 채움 (C -> B)
                if (levelB + levelC <= limitB) {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    tmpLevelB += tmpLevelC;
                    tmpLevelC = 0;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }
                } else {
                    tmpLevelA = levelA;
                    tmpLevelB = levelB;
                    tmpLevelC = levelC;

                    sub = limitB - tmpLevelB;

                    tmpLevelB = limitB;
                    tmpLevelC -= sub;

                    if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                        q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                        visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                    }

                    if (tmpLevelA + tmpLevelC <= limitA) {
                        tmpLevelA += tmpLevelC;
                        tmpLevelC = 0;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    } else {
                        tmpLevelC -= (limitA - tmpLevelA);
                        tmpLevelA = limitA;

                        if (!visited[tmpLevelA][tmpLevelB][tmpLevelC]) {
                            q.add(new Pair(tmpLevelA, tmpLevelB, tmpLevelC));
                            visited[tmpLevelA][tmpLevelB][tmpLevelC] = true;
                        }
                    }
                }

                // a부터 채움 (C -> A)
                if (levelA + levelC <= limitA) { // 원문 로직 그대로 둠
                    int tmpLevelA2 = levelA;
                    int tmpLevelB2 = levelB;
                    int tmpLevelC2 = levelC;

                    tmpLevelA2 += tmpLevelC2;
                    tmpLevelC2 = 0;

                    if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                        q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                        visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                    }
                } else {
                    int tmpLevelA2 = levelA;
                    int tmpLevelB2 = levelB;
                    int tmpLevelC2 = levelC;

                    int sub2 = limitA - tmpLevelA2;

                    tmpLevelA2 = limitA;
                    tmpLevelC2 -= sub2;

                    if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                        q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                        visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                    }

                    if (tmpLevelB2 + tmpLevelC2 <= limitB) {
                        tmpLevelB2 += tmpLevelC2;
                        tmpLevelC2 = 0;

                        if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                            q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                            visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                        }
                    } else {
                        tmpLevelC2 -= (limitB - tmpLevelB2);
                        tmpLevelB2 = limitB;

                        if (!visited[tmpLevelA2][tmpLevelB2][tmpLevelC2]) {
                            q.add(new Pair(tmpLevelA2, tmpLevelB2, tmpLevelC2));
                            visited[tmpLevelA2][tmpLevelB2][tmpLevelC2] = true;
                        }
                    }
                }
            }
        }
    }
}

class Pair {
    private final int levelA;
    private final int levelB;
    private final int levelC;

    public Pair(int levelA, int levelB, int levelC) {
        this.levelA = levelA;
        this.levelB = levelB;
        this.levelC = levelC;
    }

    public int getLevelA() {
        return levelA;
    }

    public int getLevelB() {
        return levelB;
    }

    public int getLevelC() {
        return levelC;
    }
}
