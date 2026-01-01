import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : participant){
            if(map.containsKey(s)){
                int val = map.get(s);
                map.replace(s, val+1);
            }else {
                map.put(s,1);
            }
        }
        
        for(String s : completion){
            int val = map.get(s);
            map.replace(s, val-1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            
            if(val>0) return key;
        }
        
        return "";
    }
}