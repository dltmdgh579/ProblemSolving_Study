import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] minAlpha = new int[26];
        Arrays.fill(minAlpha, Integer.MAX_VALUE);
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char key = keymap[i].charAt(j);
                
                minAlpha[key - 'A'] = Math.min(minAlpha[key - 'A'], j + 1);
            }
        }

        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                if(minAlpha[targets[i].charAt(j) - 'A'] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break; 
                }
                answer[i] += minAlpha[targets[i].charAt(j) - 'A'];
            }
            if(answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        }
        
        return answer;
    }
}