import java.util.*;

class Solution {
    private int minCost = Integer.MAX_VALUE;
    private int[] da = {0,0,1,-1}; // left, right, down, up
    private int[] db = {-1,1,0,0}; // 0, 1, 2, 3
    private int[][] costArr = new int[26][26];

    public int solution(int[][] board) {
        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < 26 ; j++){
                costArr[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0,0,board);
        return minCost;
    }
    
    private void bfs(int startA, int startB, int[][] board){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startA, startB, 0, 0));
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int a = pair.getA();
            int b = pair.getB();
            int cost = pair.getCost();
            int dir = pair.getDir();
            
            if(cost>minCost){
                continue;
            }
            
            if(a==board.length-1 && b==board.length-1){
                minCost = Math.min(cost,minCost);
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int na = a + da[i];
                int nb = b + db[i];
                
                if(na>=0 && na<board.length && nb>=0 && nb<board.length && board[na][nb] != 1 && costArr[na][nb]>=cost){
                    if(a==0 && b==0){
                        q.add(new Pair(na,nb,cost+100,i));
                        costArr[na][nb] = cost+100;
                    }else{
                        if(dir==i){
                            q.add(new Pair(na,nb,cost+100,i));
                            costArr[na][nb] = cost+100;
                        }else{
                            q.add(new Pair(na,nb,cost+100+500,i));
                            costArr[na][nb] = cost+100+500;
                        }
                    }
                }
            }
        }
    }
}

class Pair{
    private int a;
    private int b;
    private int cost;
    private int dir;
    
    public Pair(int a, int b, int cost, int dir){
        this.a = a;
        this.b = b;
        this.cost = cost;
        this.dir = dir;
    }
    
    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }
    
    public int getCost(){
        return this.cost;
    }
    
    public int getDir(){
        return this.dir;
    }
}