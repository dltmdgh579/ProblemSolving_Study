import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.replaceAll("[\\{\\}]", "");
        String[] strArr = s.split(",");
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<strArr.length; i++){
            int key = Integer.parseInt(strArr[i]);
            map.put(key, map.getOrDefault(key, 1) + 1);
        }
        
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        answer = new int[keySet.size()];
        
        int idx = 0;
        for(int key : keySet){
            answer[idx++] = key;
        }
                
        return answer;
    }
}