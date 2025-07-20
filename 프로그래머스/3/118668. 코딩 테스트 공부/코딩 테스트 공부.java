import java.util.*;

class Solution {
    private int MAX_ALP = 0;
    private int MAX_COP = 0;
    private int initAlp;
    private int initCop;
    
    private int[][] dp;
    private int[][] problems;
    
    public int solution(int alp, int cop, int[][] problems) {
        this.problems = problems;
        this.initAlp = alp;
        this.initCop = cop;
        
        getMax();
        init();
        return getAnswer();
    }
    
    private int getAnswer(){
        for(int i = initCop ; i <= MAX_COP ; i++){
            for(int j = initAlp ; j <= MAX_ALP ; j++){
                if(j+1<=MAX_ALP){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                
                if(i+1<=MAX_COP){
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                
                for(int k = 0 ; k < problems.length ; k++){
                    int tmpAlp = problems[k][0];
                    int tmpCop = problems[k][1];
                    
                    if(i>=tmpCop && j>=tmpAlp){
                        int newAlp = Math.min(MAX_ALP, j+problems[k][2]);
                        int newCop = Math.min(MAX_COP, i+problems[k][3]);
                        
                        dp[newCop][newAlp] = Math.min(dp[newCop][newAlp], dp[i][j]+problems[k][4]);
                    }
                }
            }
        }
            
        return dp[MAX_COP][MAX_ALP];
    }
    
    private void init(){
        initAlp = Math.min(initAlp, MAX_ALP);
        initCop = Math.min(initCop, MAX_COP);

        dp = new int[MAX_COP+1][MAX_ALP+1];
        
        for(int i = 0 ; i<=MAX_COP ; i++){
            for(int j = 0 ; j<=MAX_ALP ; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[initCop][initAlp] = 0;
    }
    
    private void getMax(){
        for(int i = 0 ; i < problems.length ; i++){
            if(MAX_ALP < problems[i][0]){
                MAX_ALP = problems[i][0];
            }
            
            if(MAX_COP < problems[i][1]){
                MAX_COP = problems[i][1];
            }
        }
    }
}