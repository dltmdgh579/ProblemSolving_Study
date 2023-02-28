class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] div_count = new int[100001];
        
        for(int i=1; i<=number; i++){
            int count = 0;
            boolean flag = false;
            for(int j=1; j<=Math.sqrt(i); j++){
                if(j*j == i) flag = true;
                if(i%j == 0) count++;
            }
            if(flag) count = 2 * count - 1;
            else count = 2 * count;
            div_count[i] = count;
            
            if(count > limit) count = power;
            
            answer += count;
        }
        
        return answer;
    }
}