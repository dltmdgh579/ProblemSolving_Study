class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str_arr = s.split(" ");
        
        for(int i=0; i<str_arr.length; i++){
            String cur = str_arr[i];            
            if(cur.length() == 0){
                answer += " ";  
            }
            else {
                answer += cur.substring(0, 1).toUpperCase();
                answer += cur.substring(1, cur.length()).toLowerCase();
                answer += " ";
            }
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        } else {
            answer = answer.substring(0, answer.length()-1);
        }
        
        return answer;
    }
}