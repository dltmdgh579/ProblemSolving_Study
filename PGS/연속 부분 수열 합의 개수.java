import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            int sum = 0;
            for(int j=i; j<elements.length+i; j++){
                sum += elements[j%elements.length];
                set.add(sum);
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}