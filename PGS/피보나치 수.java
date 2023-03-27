class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]%1234567 + dp[i-2]%1234567;
        }
        
        answer = dp[n]%1234567;
        
        return answer;
    }
}