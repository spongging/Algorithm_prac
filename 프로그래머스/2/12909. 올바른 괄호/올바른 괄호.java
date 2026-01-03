import java.util.*;

class Solution {
    boolean solution(String s) {
        return isPossible(s);
    }
    
    private boolean isPossible(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            
            if(c=='('){
                st.push(c);
            }else {
                if(st.size()==0) return false;
                st.pop();
            }
        }
        
        if(st.size()>0) return false;
        return true;
    }
}