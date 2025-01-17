import java.util.*;

class Solution {
    private HashMap<String, Integer> map = new HashMap<>();
    private HashMap<String, ArrayList<int[]>> idx = new HashMap<>();
    private int[] answer;
    private ArrayList<Integer> tmpAnswer = new ArrayList<>();
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 계산
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르를 총 재생 횟수 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        // 정렬된 데이터를 LinkedHashMap에 저장
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (var entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        // 장르별로 곡 인덱스와 재생 횟수를 저장
        for (int i = 0; i < genres.length; i++) {
            idx.putIfAbsent(genres[i], new ArrayList<>());
            idx.get(genres[i]).add(new int[] {i, plays[i]});
        }
        
        // 각 장르별 곡 리스트를 재생 횟수 내림차순 + 인덱스 오름차순으로 정렬
        for (Map.Entry<String, ArrayList<int[]>> entry : idx.entrySet()) {
            entry.getValue().sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // 재생 횟수 내림차순
                return a[0] - b[0]; // 인덱스 오름차순
            });
        }
        
        // 정렬된 장르에서 상위 2곡 선정
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String tmpGenre = entry.getKey();
            ArrayList<int[]> tmpPlays = idx.get(tmpGenre);

            int cnt = 0;
            for (int i = 0; i < tmpPlays.size(); i++) {
                if (cnt == 2) break;
                tmpAnswer.add(tmpPlays.get(i)[0]); // 곡의 인덱스를 추가
                cnt++;
            }
        }
        
        // 결과 배열 생성
        answer = new int[tmpAnswer.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tmpAnswer.get(i);
        }
        
        return answer;
    }
}
