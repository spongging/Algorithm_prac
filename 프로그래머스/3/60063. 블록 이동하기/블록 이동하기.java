import java.util.*;

class Solution {
    private int N;
    
    private int[][] board;
    private boolean[][][] visited;
    
    public int solution(int[][] board) {
        this.board = board;
        this.N = board.length;
        this.visited = new boolean[101][101][2];
        
        return bfs();
    }
    
    private int bfs(){
        Queue<State> q = new LinkedList<>();
        int answer = 0;
        
        q.offer(new State(0,0,0,0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            State s = q.poll();
            
            int ca = s.getA();
            int cb = s.getB();
            int cDir = s.getDir();
            int cTime = s.getTime();

        
            if (cDir == 0 && ca == N-1 && cb == N-2) {
                answer = cTime;
                break;
            }
            
            if (cDir == 1 && ca == N-2 && cb == N-1) {
                answer = cTime;
                break;
            }
            
            if(cDir==0){
                 // up        
                if(boundaryCheck(ca-1,cb) && !visited[ca-1][cb][0] && board[ca-1][cb]==0 && board[ca-1][cb+1]==0){
                    visited[ca-1][cb][0] = true;
                    q.offer(new State(ca-1, cb, 0, cTime+1));
                }
                
                // right
                 if(boundaryCheck(ca,cb+1)&& cb+2<N && board[ca][cb+1]==0 && board[ca][cb+2]==0&& !visited[ca][cb+1][0] ){
                    visited[ca][cb+1][0] = true;
                    q.offer(new State(ca, cb+1, 0, cTime+1));
                }
                
                // down
                 if(boundaryCheck(ca+1,cb) && !visited[ca+1][cb][0] && board[ca+1][cb]==0 && board[ca+1][cb+1]==0 ){
                    visited[ca+1][cb][0] = true;
                    q.offer(new State(ca+1, cb, 0, cTime+1));
                }
                
                // left
                 if(boundaryCheck(ca,cb-1) && !visited[ca][cb-1][0] && board[ca][cb-1]==0){
                    visited[ca][cb-1][0] = true;
                    q.offer(new State(ca, cb-1, 0, cTime+1));
                }
                
                // 아래로 회전
                if(ca+1<N && board[ca+1][cb]==0 && board[ca+1][cb+1]==0){
                    //기준축 왼쪽점
                    if(!visited[ca][cb][1]){
                        visited[ca][cb][1] = true;
                        q.offer(new State(ca,cb,1,cTime+1));
                    }
                    
                    //기준축 오른점
                    if(!visited[ca][cb+1][1]){
                        visited[ca][cb+1][1] = true;
                        q.offer(new State(ca,cb+1,1,cTime+1));
                    }
                }
                
                //위로 회전
                if(ca-1>=0 && board[ca-1][cb]==0 && board[ca-1][cb+1]==0){
                    // 기준왼
                    if(!visited[ca-1][cb][1]){
                        visited[ca-1][cb][1] = true;
                        q.offer(new State(ca-1,cb,1,cTime+1));
                    }
                    
                    // 기준오
                    if(!visited[ca-1][cb+1][1]){
                        visited[ca-1][cb+1][1] = true;
                        q.offer(new State(ca-1,cb+1,1,cTime+1));
                    }
                }
            }else{
                // up        
                if(boundaryCheck(ca-1,cb) && !visited[ca-1][cb][1] && board[ca-1][cb]==0){
                    visited[ca-1][cb][1] = true;
                    q.offer(new State(ca-1, cb, 1, cTime+1));
                }
                
                // right
                 if(cb+1 < N && ca+1 < N && boundaryCheck(ca,cb+1) && board[ca][cb+1]==0 && board[ca+1][cb+1]==0 && !visited[ca][cb+1][1] ){
                    visited[ca][cb+1][1] = true;
                    q.offer(new State(ca, cb+1, 1, cTime+1));
                }
                
                // down
                 if(boundaryCheck(ca+1,cb) && boundaryCheck(ca+2, cb) && !visited[ca+1][cb][1] && board[ca+1][cb]==0 && board[ca+2][cb]==0 ){
                    visited[ca+1][cb][1] = true;
                    q.offer(new State(ca+1, cb, 1, cTime+1));
                }
                
                // left
                 if(boundaryCheck(ca,cb-1)&& boundaryCheck(ca+1, cb-1) && !visited[ca][cb-1][1] && board[ca][cb-1]==0  && board[ca+1][cb-1]==0 ){
                    visited[ca][cb-1][1] = true;
                    q.offer(new State(ca, cb-1, 1, cTime+1));
                }
                
                // ->로 회전
                if(boundaryCheck(ca,cb+1) && boundaryCheck(ca+1,cb+1)&& board[ca][cb+1]==0 && board[ca+1][cb+1]==0){
                    //기준축 윗점
                    if(!visited[ca][cb][0]){
                        visited[ca][cb][0] = true;
                        q.offer(new State(ca,cb,0,cTime+1));
                    }
                    
                    //기준축 아랫점
                    if(!visited[ca+1][cb][0]){
                        visited[ca+1][cb][0] = true;
                        q.offer(new State(ca+1,cb,0,cTime+1));
                    }
                }
                
                //<-로 회전
                if(boundaryCheck(ca,cb-1) && boundaryCheck(ca+1,cb-1) && board[ca][cb-1]==0 && board[ca+1][cb-1]==0){
                    // 기준위
                    if(!visited[ca][cb-1][0]){
                        visited[ca][cb-1][0] = true;
                        q.offer(new State(ca,cb-1,0,cTime+1));
                    }
                    
                    // 기준아래
                    if(!visited[ca+1][cb-1][0]){
                        visited[ca+1][cb-1][0] = true;
                        q.offer(new State(ca+1,cb-1,0,cTime+1));
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean boundaryCheck(int a, int b){
        return a>=0 && b>=0 && a<N && b<N;
    }
        
}

class State{
    // 가로는 왼쪽이 기준, 새로는 윗쪽이 기준
    private int a;
    private int b;
    private int dir; //가 : 0 새 : 1
    private int time;
    
    public State(int a, int b, int dir, int time){
        this.a = a;
        this.b = b;
        this.dir = dir;
        this.time = time;
    }
    
    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }
    
    public int getDir(){
        return this.dir;
    }
    
    public int getTime(){
        return this.time;
    }
}