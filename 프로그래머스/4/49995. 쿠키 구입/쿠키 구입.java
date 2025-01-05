import java.util.*;
class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int total = sumArr(cookie);
        int rightIdx; int leftIdx;
        int sumL = 0 ; int sumR = 0;
        for(int i = 1; i<cookie.length ; i++){
            rightIdx = i;
            leftIdx = i-1;
            sumL = cookie[leftIdx];
            sumR = cookie[rightIdx];
            while(true){
                if(sumL>sumR){
                    if(rightIdx+1<cookie.length){
                        sumR+=cookie[++rightIdx];                    
                    }
                    else break;
                }
                else if(sumL<sumR){
                    if(leftIdx-1>=0){
                        sumL+=cookie[--leftIdx];
                    }
                    else break;
                }
                else{
                    answer = Math.max(answer,sumR);
                    if(rightIdx+1<cookie.length){
                        sumR+=cookie[++rightIdx];                    
                    }
                    else break;
                }
            }
        }
        return answer;
    }
    
    private int sumArr(int[] cookie){
        int sum = 0;
        for(int i = 0 ; i<cookie.length ; i++){
            sum+=cookie[i];
        }
        return sum;
    }
}