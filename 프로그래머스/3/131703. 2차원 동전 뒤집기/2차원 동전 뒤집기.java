import java.util.*;

class Solution {
    private int N, M;
    private int best = Integer.MAX_VALUE;
    
    private int[][] beginning;
    private int[][] target;
    private final boolean[] visitedRow = new boolean[10];
    
    public int solution(int[][] beginning, int[][] target) {
        this.beginning = beginning;
        this.target = target;
        N = target.length;
        M = target[0].length;
        
        dfs(0);
        
        if(best==Integer.MAX_VALUE){
            return -1;
        }else{
            return best;
        }
    }
    
    private void dfs(int idx){
        if(idx==N){
            flipRowAndColumn();
            return;
        }
        
        visitedRow[idx] = false;
        dfs(idx + 1);
        visitedRow[idx] = true;
        dfs(idx + 1);
    }
    
    private void flipRowAndColumn(){
        int[][] tmpArr = new int[N][M];
        int flip = 0; 
        
        // 깊은 복사
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                tmpArr[i][j] = beginning[i][j];
            }
        }
        
        flip += flipRow(tmpArr);
        
        if(best<flip){
            return;
        }
        
        flip+=flipColumn(tmpArr);
        
        if(best<flip){
            return;
        }
        
        if(isMatch(tmpArr)){
            best = Math.min(best, flip);
        }
        
    }
    
    private boolean isMatch(int[][] tmpArr){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(tmpArr[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    private int flipColumn(int[][] tmpArr){
        int tmpFlip = 0;
        
        for(int i = 0 ; i < M ; i++){
            if(tmpArr[0][i]!=target[0][i]){
                tmpFlip++;
                
                for(int j = 0; j < N ; j++){
                    if(tmpArr[j][i]==1){
                        tmpArr[j][i] = 0;
                    }else {
                        tmpArr[j][i] = 1;
                    }
                }
            }
        }
        
        return tmpFlip;
    }
    
    private int flipRow(int[][] tmpArr){
        int tmpFlip = 0;
        
        for(int i = 0 ; i < N ; i++){
            if(visitedRow[i]){
                tmpFlip++;
                
                for(int j = 0 ; j < M ; j++){
                    if(tmpArr[i][j]==1){
                        tmpArr[i][j] = 0;
                    }else{
                        tmpArr[i][j] = 1;
                    }
                }   
            }
        }
        return tmpFlip;
    }
}

// dfs? => 2^20 승 x 100(target이랑 맞는 지) = 1억 약간 넘음 애매함