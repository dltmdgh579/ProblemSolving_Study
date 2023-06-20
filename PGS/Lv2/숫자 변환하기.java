class Solution {
    static int MAX = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        
        
        for(int i=x+1; i<=y; i++){
            int a = MAX, b = MAX, c = MAX, d = 0;
            if(i-n >= x) a = dp[i-n];
            if(i/2 >= x && i%2 == 0) b = dp[i/2];
            if(i/3 >= x && i%3 == 0) c = dp[i/3];
            
            d = Math.min(a, Math.min(b, c));
            
            dp[i] = (d < MAX) ? d + 1 : MAX;
        }
        
        answer = (dp[y] < MAX) ? dp[y] : -1;
        
        return answer;
    }
}