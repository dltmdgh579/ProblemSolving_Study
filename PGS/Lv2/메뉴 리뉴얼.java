import java.util.*;
class Solution {
    static List<String> result = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int len : course){
            for(String order : orders){
                combination("", order, len);
            }
            
            if(!map.isEmpty()){
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);
                
                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max){
                            result.add(key);
                        }
                    }
                }
            }
            map.clear();
        }
        
        Collections.sort(result);
        answer = new String[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public void combination(String order, String others, int count){
        if(count == 0){
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for(int i=0; i<others.length(); i++){
            combination(order + others.charAt(i), others.substring(i+1), count-1);
        }
    }
}