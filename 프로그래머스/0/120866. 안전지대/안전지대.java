class Solution {
   int [][] newBoard = new int[100][100];
   int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
   int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public int solution(int[][] board) {
        
        int answer = 0;
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]==1){
                    newBoard[i][j] = 1;
                    search(board,i,j);
                }
            }
        }
        answer = count(board);
        return answer;
    }
    private void search(int[][]board, int a, int b){
        for(int i = 0; i< 8 ; i++){
            int ny = dy[i]+a;
            int nx = dx[i]+b;
            if(ny<0 || ny>=board.length || nx<0 || nx>=board[a].length) continue;
            newBoard[ny][nx] = 1;
        }
    }
    private int count(int [][]board){
        int cnt = 0;
        for(int i = 0 ; i<board.length ; i++){
            for(int j = 0; j<board[i].length; j++){
                if(newBoard[i][j]==0){
                   cnt++;
                }
            }
        }
        return cnt;
    }
}
