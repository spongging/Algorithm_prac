import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length/2;
        
        for(int i = 0 ; i < n*2 ; i++){
            set.add(nums[i]);
        }
        
        if(n<set.size()){
            return n;
        }else return set.size();
    }
}