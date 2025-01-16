import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        return binarySearch(stones, k);
    }
    
    private int binarySearch(int[] stones, int k){
        int left = 1;
int right = Arrays.stream(stones).max().orElse(0);        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(!isPossible(stones, mid, k)){
                right = mid-1;  
            }
            else{
                answer = mid+1; 
                left = mid+1;
            }
        }
        return answer;
    }
    
    private boolean isPossible(int[] stones, int mid, int k){
        int countZero = 0;
        for(int num : stones){
            if(num-mid<=0){
                countZero++;
                if(countZero>=k) return false;
            }
            else countZero = 0;
        }
        if(countZero>=k) return false;
        return true;
    }
}