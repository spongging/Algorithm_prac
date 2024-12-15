class Solution {
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[501][501];
        dp[0][0] = triangle[0][0];
        answer = doDp(triangle,dp);
        return answer;
    }
    
    private int doDp(int [][] triangle, int[][] dp){
        for(int i = 1 ; i<triangle.length ; i++){
            for(int j = 0; j<=i ; j++){
                if(j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        return searchMax(dp, triangle.length);
    }
    
    private int searchMax(int[][] dp, int size){
        int maxNum = 0;
        for(int i = 0 ; i < size ; i++){
            if(maxNum<dp[size-1][i]){
                maxNum = dp[size-1][i];
            }
        }
        return maxNum;
    }
}