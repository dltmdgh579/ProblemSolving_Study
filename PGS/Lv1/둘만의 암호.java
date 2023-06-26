import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Set<Character> set = new HashSet<>();
        
        for(char c : skip.toCharArray()){
            set.add(c);
        }
        
        for(char c : s.toCharArray()){
            int count = index;
            
            while(count > 0){
                if(c == 'z') c = 'a' - 1;
                if(!set.contains(++c)){
                    count--;
                }
            }
            
            answer += c;
        }
        
        return answer;
    }
}