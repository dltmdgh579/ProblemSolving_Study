import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int idx = 0;
        while(k > 0){
            k -= map.get(keyList.get(idx++));
            answer++;
        }
        
        return answer;
    }
}