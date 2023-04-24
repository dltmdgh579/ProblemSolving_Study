class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.insert(0, n%k);
            n /= k;
        }
        
        for(int i=0; i<sb.length(); i++){
            boolean flag = false;
            
            if(sb.charAt(i)-'0' > 0){
                StringBuilder sb2 = new StringBuilder();
                while(i != sb.length() && sb.charAt(i)-'0' != 0){
                    sb2.append(sb.charAt(i));
                    i += 1;
                }
                
                long num = Long.parseLong(sb2.toString());
                if(num == 1) flag = true;
                for(int j=2; j<=Math.sqrt(num); j++){
                    if(num%j == 0) flag = true;
                }
                
                if(!flag) answer += 1;
            }
            
        }
        
        return answer;
    }
}