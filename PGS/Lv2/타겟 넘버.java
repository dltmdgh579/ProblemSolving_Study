class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    public void dfs(int start, int cnt, int[] numbers, int target){
        if(cnt == numbers.length){
            int sum = 0;
            for(int i=0; i<numbers.length; i++){
                sum += numbers[i];
            }
            if(sum == target) answer++;
            
            return;
        }
        
        for(int i=start; i<numbers.length; i++){
            dfs(i+1, cnt+1, numbers, target);
            numbers[i] = -numbers[i];
            dfs(i+1, cnt+1, numbers, target);
            numbers[i] = -numbers[i];
        }
        
    }
}