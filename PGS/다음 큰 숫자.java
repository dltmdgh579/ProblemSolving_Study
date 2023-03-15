class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toBinaryString(n);
        
        int count = 0;
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        
        for(int i=n+1; i<=1000000; i++){
            String tmp_str = Integer.toBinaryString(i);
            
            int tmp_count = 0;
            
            for(int j=0; j<tmp_str.length(); j++){
                if(tmp_str.charAt(j) == '1'){
                    tmp_count++;
                }
            }
            
            if(count == tmp_count) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}