import java.util.*;

class Solution {
    private int[] sequence1; // 1,-1,1,-1
    private int[] sequence2; // -1,1,-1,1
    
    public long solution(int[] sequence) {
        init(sequence);
        long maxResult1 = findMaxSubSequence(sequence1);
        long maxResult2 = findMaxSubSequence(sequence2);
        
        return Math.max(maxResult1, maxResult2);
    }
    
    private void init(int[] sequence){
        sequence1 = new int[sequence.length];
        sequence2 = new int[sequence.length];
        
        for(int i = 0 ; i < sequence.length ; i++){
            if(i%2==0){
                sequence1[i] = sequence[i];
                sequence2[i] = sequence[i] * -1;
            }else{
                sequence1[i] = sequence[i] * -1;
                sequence2[i] = sequence[i];
            }
        }
        return;
    }
    
    private long findMaxSubSequence(int[] sequence){
        long tempMax = sequence[0];
        long[] dp = new long[sequence.length];
        dp[0] = sequence[0];
        
        for(int i = 1 ; i < dp.length ; i++){
            if(dp[i-1] <= 0){
                dp[i] = sequence[i];
            }else{
                dp[i] = dp[i-1] + sequence[i];
                tempMax = Math.max(tempMax, dp[i]);
            }
        }
        
        return tempMax;
    }
}