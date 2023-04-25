import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        int index = 27;
        
        for(int i=0; i<26; i++){
            map.put(String.valueOf((char) ('A' + i)), i+1); 
        }
        
        for(int i=0; i<msg.length(); i++){
            boolean flag = false;
            int idx = i;
            if(i < msg.length()){
                String cur = msg.substring(idx, i+1);
                
                if(map.containsKey(cur)){
                    while(true){
                        if(map.containsKey(cur)){
                            i++;
                            if(i == msg.length()) {
                                flag = true;
                                break;
                            }
                            cur = msg.substring(idx, i+1);
                        } else {
                            i--;
                            list.add(map.get(cur.substring(0, cur.length()-1)));
                            map.put(cur, index++);
                            break;
                        }
                    }

                    if(flag) {
                        list.add(map.get(cur));
                        break;
                    }
                } else {
                    list.add(map.get(cur));
                }
            }
        }
        
        answer = new int[list.size()];
        
        int idx = 0;
        for(int n : list){
            answer[idx++] = n;
        }
        
        return answer;
    }
}