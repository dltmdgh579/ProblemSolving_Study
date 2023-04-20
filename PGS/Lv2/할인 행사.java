import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            boolean flag = false;
            Map<String, Integer> copyMap = new HashMap<>(map);
            for(int j=i; j<i+10; j++){
                if(copyMap.containsKey(discount[j])){
                    copyMap.replace(discount[j], copyMap.get(discount[j])-1);
                    if(copyMap.get(discount[j]) < 0) {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        
        
        return answer;
    }
}