class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long p_num = Long.parseLong(p);
        
        for(int i=0; i<=t.length() - p.length(); i++){
            String str = t.substring(i, i+p.length());
            
            Long num = Long.parseLong(str);
            if(num <= p_num) answer++;
        }
        
        return answer;
    }
}