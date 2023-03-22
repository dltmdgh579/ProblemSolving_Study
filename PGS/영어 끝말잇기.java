import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        HashSet<String> word_set = new HashSet<>();
        boolean flag = false;
        int count = 0;
        int fail_num = 0;
        
        for(int i=0; i<words.length - 1; i++){
            char endChar = words[i].charAt(words[i].length()-1);
            char startChar = words[i+1].charAt(0);
            
            word_set.add(words[i]);
            
            if(i%n == 0){
                count++;
            }
            
            if(endChar != startChar){
                fail_num = (i+1)%n+1;
                flag = true;
                if((i+1)%n == 0) count++;
                break;
            }
            
            if(word_set.contains(words[i+1])){
                fail_num = (i+1)%n+1;
                flag = true;
                if((i+1)%n == 0) count++;
                break;
            }
            
        }
        if(flag){
            answer = new int[] {fail_num, count};
        } else {
            answer = new int[] {0, 0};
        }
        return answer;
    }
}