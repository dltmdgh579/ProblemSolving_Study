import java.util.*;
class Solution {
    static boolean[] visited, duplicated;
    static HashSet<Integer> set;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(numbers, "", 0);
        
        return set.size();
    }
    
    public void dfs(String numbers, String tempNum, int cnt) {
        if(!tempNum.equals("") && isPrime(tempNum)) {
            set.add(Integer.parseInt(tempNum));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, tempNum + numbers.charAt(i), cnt + 1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(String tempNum){
        int num = Integer.parseInt(tempNum);
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}