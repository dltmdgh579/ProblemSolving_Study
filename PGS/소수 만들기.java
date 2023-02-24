class Solution {
    static int count;
    static int[] selected;
    static boolean[] checked;
    public int solution(int[] nums) {
        int answer = -1;
        selected = new int[3];
        checked = new boolean[nums.length];
        
        dfs(nums, 0, 0);
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int[] nums, int cnt, int start){
        if(cnt == 3){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += selected[i];
            }
            for(int i=2; i<=Math.sqrt(sum); i++){
                if(sum%i == 0) return;
            }
            count++;
            return;
        }
        
        
        for(int i=start; i<nums.length; i++){
            if(checked[i]) continue;
            selected[cnt] = nums[i];
            checked[i] = true;
            dfs(nums, cnt+1, i+1);
            checked[i] = false;
        }
    }
}