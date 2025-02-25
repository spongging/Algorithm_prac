import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private char[] board = new char[9];
    private int countO;
    private int countX;
    private boolean exception;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (true) {
            String line = br.readLine();

            if (line == null || line.equals("end")) {
                break;
            }

            for (int i = 0; i < 9; i++) {
                board[i] = line.charAt(i);
            }

            if (!countingOandX()) {
                printInvalid();
                continue;
            }

            if (isPatternCorrect()) {
                if (exception) {
                    printInvalid();
                    continue;
                }
                printValid();
                continue;
            }

            if (isBlankExist()) {
                printInvalid();
            } else {
                printValid();
            }
        }
    }

    private boolean isBlankExist() {
        for (char c : board) {
            if (c == '.') {
                return true;
            }
        }

        return false;
    }

    private boolean isPatternCorrect() {
        boolean isXwin = false;
        boolean isOwin = false;
        boolean isPatternRight = false;
        exception = false;

        if (board[0] != '.' && board[0] == board[1] && board[1] == board[2]) { // 가로
            isPatternRight = true;

            if (board[0] == 'O') {
                isOwin = true;
            } else if (board[0] == 'X') {
                isXwin = true;
            }

        }

        if (board[3] != '.' && board[3] == board[4] && board[4] == board[5]) {
            isPatternRight = true;

            if (board[3] == 'O') {
                isOwin = true;
            } else if (board[3] == 'X') {
                isXwin = true;
            }

        }

        if (board[6] != '.' && board[6] == board[7] && board[7] == board[8]) {
            isPatternRight = true;

            if (board[6] == 'O') {
                isOwin = true;
            } else if (board[6] == 'X') {
                isXwin = true;
            }
        }

        if (board[0] != '.' && board[0] == board[3] && board[3] == board[6]) { // 새로
            isPatternRight = true;

            if (board[0] == 'O') {
                isOwin = true;
            } else if (board[0] == 'X') {
                isXwin = true;
            }

        }

        if (board[1] != '.' && board[1] == board[4] && board[4] == board[7]) {
            isPatternRight = true;

            if (board[1] == 'O') {
                isOwin = true;
            } else if (board[1] == 'X') {
                isXwin = true;
            }

        }

        if (board[2] != '.' && board[2] == board[5] && board[5] == board[8]) {
            isPatternRight = true;

            if (board[2] == 'O') {
                isOwin = true;
            } else if (board[2] == 'X') {
                isXwin = true;
            }
        }

        if (board[0] != '.' && board[0] == board[4] && board[4] == board[8]) { // 대각선
            isPatternRight = true;

            if (board[0] == 'O') {
                isOwin = true;
            } else if (board[0] == 'X') {
                isXwin = true;
            }

        }

        if (board[2] != '.' && board[2] == board[4] && board[4] == board[6]) {
            isPatternRight = true;

            if (board[2] == 'O') {
                isOwin = true;
            } else if (board[2] == 'X') {
                isXwin = true;
            }
        }

        if (isOwin && isXwin) {
            exception = true;
        }

        if (isXwin && countX != countO + 1) {
            exception = true;
        }

        if (isOwin && countX != countO) {
            exception = true;
        }

        return isPatternRight;
    }

    private boolean countingOandX() {
        countO = 0;
        countX = 0;

        for (char c : board) {
            if (c == 'X') {
                countX++;
            } else if (c == 'O') {
                countO++;
            }
        }

        if (countX < countO) {
            return false;
        }

        if (countX == countO || countX - 1 == countO) {
            return true;
        }

        return false;
    }

    private boolean input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line==null || line.equals("end")) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            board[i] = line.charAt(i);
        }

        return true;
    }

    private void printInvalid() {
        System.out.println("invalid");
    }

    private void printValid() {
        System.out.println("valid");
    }
}

