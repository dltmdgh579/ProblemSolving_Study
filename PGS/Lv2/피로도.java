class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int cnt){
        answer = Math.max(answer, cnt);
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
}