import java.util.*;
class Solution {
    private int cnt;
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0 ; i<s.length ; i++){
            answer[i] = reOrder(s[i]);
        }
        return answer;
    }
    
    private String reOrder(String s){
        cnt = 0;
        StringBuilder remainder = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++){
            remainder.append(s.charAt(i));
            if(remainder.length()>=3 && remainder.substring(remainder.length()-3).equals("110")){
                cnt++;
                remainder.delete(remainder.length()-3,remainder.length());
            }
        }
        int lastIdx0 = findLastIdxOf0(remainder.toString());
        
        for(int i = 1 ; i <= cnt ; i++){
            remainder.insert(lastIdx0+1,"110");
        }
        return remainder.toString();
    }
    
    private int findLastIdxOf0(String s){
        return s.lastIndexOf('0');
    }
}