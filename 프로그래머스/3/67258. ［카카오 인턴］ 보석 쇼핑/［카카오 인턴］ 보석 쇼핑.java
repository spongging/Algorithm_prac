import java.util.*;

class Solution {
    private Set<String> countKind = new HashSet<>();
    private Map<String, Integer> countPresentKind = new HashMap<>();
    private int st = 0;
    private int ed = 0;
    private int[] answer = new int[2];
    
    public int[] solution(String[] gems) {
        // 전체 보석 종류를 확인
        for (String gem : gems) {
            countKind.add(gem);
        }
        
        // 현재 보석의 범위와 종류 추적
        int dist = Integer.MAX_VALUE;
        while (ed < gems.length) {
            // 보석 추가
            countPresentKind.put(gems[ed], countPresentKind.getOrDefault(gems[ed], 0) + 1);
            
            // 모든 종류의 보석을 포함하고 있는 경우
            while (countPresentKind.size() == countKind.size()) {
                // 최소 거리 갱신
                if (ed - st < dist) {
                    dist = ed - st;
                    answer[0] = st + 1;
                    answer[1] = ed + 1;
                }
                
                // 범위 축소
                countPresentKind.put(gems[st], countPresentKind.get(gems[st]) - 1);
                if (countPresentKind.get(gems[st]) == 0) {
                    countPresentKind.remove(gems[st]);
                }
                st++;
            }
            
            ed++;
        }
        
        return answer;
    }
}
